package ContractPackage;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import validators.ContractValidator;
import validators.Message;

public class ValidatorTest {
    
    /**
     * Test of validate method, of class ContractValidator.
     */
    @Test
    public void testContractValidator() throws IOException, CsvValidationException {        
        Client cli = new Client(1, "Ivan", "Ivanov", "Ivanovich", LocalDate.of(1984, 7, 28), Gender.Male, 1, 1);
        Contract contr = new CellularContract(1, LocalDate.of(2050, 7, 28), LocalDate.of(2040, 7, 28), -56, cli, -1, -1, -1);
        ContractValidator valid = new ContractValidator();
        Message mess = valid.validate(contr);
        String err1 = "contract number less than 0";
        String err2 = "the start date of the contract is after the end date of the contract";
        String err3 = "the number of digits in the client's passport series is not 4.the number of digits in the client's passport number is not 6.";
        String err4 = " the number of minutes in the contract is less than 0. the number of gigabytes in the contract is less than 0. the number of SMS in the contract is less than 0.";
        assertTrue(mess.getErrorMessage().contains(err1));
        assertTrue(mess.getErrorMessage().contains(err2));
        assertTrue(mess.getErrorMessage().contains(err3));
        assertTrue(mess.getErrorMessage().contains(err4));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
}
