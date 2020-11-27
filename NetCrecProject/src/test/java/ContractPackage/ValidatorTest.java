package ContractPackage;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidatorTest {

    /**
     * Test of sort method, of class ValidatContract
     */
    @Test
    public void testValid1() throws ClassNotFoundException {
        System.out.println("validator1");
        String[] valstr = {"8", "03.09.2017", "03.09.2030", "5", "FailInt", "Lilya", "Belushi", "Grigorievna", "21.05.1991", "Female", "4812", "874335", "Cellular", "30 3 50"};
        ValidatContract valid = new ValidatContract();
        valid.contractValidate(valstr);
        String error_name = "element in array with index 4 and the value FailInt does not match client field with name id with type int";
        assertEquals(error_name, valid.getErrorMessage());
    }

    /**
     * Test of sort method, of class ValidatContract
     */
    @Test
    public void testValid2() throws ClassNotFoundException {
        System.out.println("validator2");
        String[] valstr = {"8", "03.09.2017", "03.09.2030", "5", "5", "Lilya", "Belushi", "Grigorievna", "21.05.1991", "Female", "4812", "874335", "WTFType", "30 3 50"};
        ValidatContract valid = new ValidatContract();
        valid.contractValidate(valstr);
        String error_name = "entered the array allows you to create a contract of the base type but does not have enough fields to expand it or cannot find class type named WTFType";
        assertEquals(error_name, valid.getErrorMessage());
    }
}
