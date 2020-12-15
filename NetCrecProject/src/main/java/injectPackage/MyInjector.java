package injectPackage;

import ContractPackage.ContractStore;
import SortedPackage.ISorted;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sortedPackage1.BubbleSorter;

@Configuration(packages = {"validators", "SortedPackage"})
public class MyInjector {

    public static void injectorValidateAndCreate(Object reposit) throws Exception {
        Configuration annot_pack = MyInjector.class.getAnnotation(Configuration.class);
        String[] packages = annot_pack.packages();
        Field[] fields = reposit.getClass().getDeclaredFields();
        List<Field> annot_fields = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyInject.class)) {
                annot_fields.add(field);
            }
        }
        for (Field annot_field : annot_fields) {
            MyInject inj_field = annot_field.getAnnotation(MyInject.class);
            Class class_for_find = inj_field.clazz();
            List<Class> found_classes = new ArrayList();
            for (String pack : packages) {
                List<Class<?>> lis = getAllClassesInPackage(pack);
                for (Class cl : lis) {
                    if(class_for_find.isAssignableFrom(cl) && !cl.equals(reposit) && !cl.isInterface() 
                            && cl.getConstructor() != null){ 
                        System.out.println(cl.getName());
                        found_classes.add(cl);
                    }
                }
            }
            if(Collection.class.isAssignableFrom(annot_field.getType())){
                System.out.println("ok");
            }else if (found_classes.size() == 1){                
                annot_field.setAccessible(true);
                annot_field.set(reposit, found_classes.get(0).newInstance());
                //annot_field.set(reposit,new BubbleSorter());
            }else{
                throw new Exception("Class type cannot be uniquely determined!");
            }
        }
    }

    public static final List<Class<?>> getAllClassesInPackage(String packageName) {
        String path = packageName.replaceAll("\\.", File.separator);
        List<Class<?>> classes = new ArrayList<>();
        String[] classPathEntries = System.getProperty("java.class.path").split(
                System.getProperty("path.separator")
        );
        for (String classpathEntry : classPathEntries) { 
            try {
                File base = new File(classpathEntry + File.separatorChar + path);
                for (File file : base.listFiles()) {
                    String name = file.getName();
                    if (name.endsWith(".class")) {
                        name = name.substring(0, name.length() - 6);
                        classes.add(Class.forName(packageName + "." + name));
                    }
                }
            } catch (Exception ex) {
            }
        }
        return classes;
    }
}
