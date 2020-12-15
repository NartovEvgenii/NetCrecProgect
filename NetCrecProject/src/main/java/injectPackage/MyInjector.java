package injectPackage;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

@Configuration(packages = {"validators", "SortedPackage"})
public class MyInjector {

    public static void injectorValidateAndCreate(Object reposit) throws Exception {
        Configuration annot_pack = MyInjector.class.getAnnotation(Configuration.class);
        String[] packages = annot_pack.packages();
        Field[] fields = reposit.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MyInject.class)) {
                if (List.class.isAssignableFrom(field.getType())) {
                    String pod_type = field.getGenericType().getTypeName().split("<")[1].replace(">", "");
                    Class class_for_find = Class.forName(pod_type);
                    List<Class> found_classes = getAllClassesWithFilter(packages, class_for_find, reposit);
                    if (found_classes.size() >= 1) {
                        List<Object> res_lis = new ArrayList<>();
                        for (Class clas_l : found_classes) {
                            res_lis.add(clas_l.newInstance());
                        }
                        field.setAccessible(true);
                        field.set(reposit, res_lis);
                    } else {
                        throw new Exception("Class type cannot be uniquely determined!");
                    }
                } else {
                    Class class_for_find = field.getType();
                    List<Class> found_classes = getAllClassesWithFilter(packages, class_for_find, reposit);
                    if (found_classes.size() == 1) {
                        field.setAccessible(true);
                        field.set(reposit, found_classes.get(0).newInstance());
                    } else {
                        throw new Exception("Class type cannot be uniquely determined!");
                    }
                }
            }
        }
    }

    public static final List<Class> getAllClassesWithFilter(String[] packages, Class class_for_find, Object reposit) {
        List<Class> found_classes = new ArrayList();
        for (String pack : packages) {
            List<Class<?>> lis = getAllClassesInPackage(pack);
            lis.forEach((cl) -> {
                try {
                    if (class_for_find.isAssignableFrom(cl) && !cl.equals(reposit.getClass()) && !cl.isInterface()
                            && cl.newInstance() != null) {
                        System.out.println(cl.getName());
                        found_classes.add(cl);
                    }
                } catch (InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(MyInjector.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
        return found_classes;
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
