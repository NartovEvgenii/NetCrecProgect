package ContractPackage;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import validators.ContractValidator;
import validators.Message;

public class ValidatorTest {
    
    @Test
    public void testContractValidator() throws IOException, CsvValidationException {        
        Client cli = new Client(1, "Ivan", "Ivanov", "Ivanovich", LocalDate.of(1984, 7, 28), Gender.Male, 1, 1);
        Contract contr = new CellularContract(1, LocalDate.of(2050, 7, 28), LocalDate.of(2040, 7, 28), -56, cli, -1, -1, -1);
        ContractValidator valid = new ContractValidator();
        Message mess = valid.validate(contr);
        String res =" \n " + "contract number less than 0 \n" +
                    " the start date of the contract is after the end date of the contract \n" +
                    " the number of digits in the client's passport series is not 4.the number of digits in the client's passport number is not 6. \n" +
                    "  the number of minutes in the contract is less than 0. the number of gigabytes in the contract is less than 0. the number of SMS in the contract is less than 0.";
        assertEquals(mess.getErrorMessage(), res);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    } 
}
