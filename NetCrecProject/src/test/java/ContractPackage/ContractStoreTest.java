package ContractPackage;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContractStoreTest {
    
    public ContractStoreTest() {
    }
    /**
     * Test of addContract method, of class ContractStore.
     */
    @Test
    public void testAddContract() {
        System.out.println("addContract");
        Client cli = new Client(1,"Ivan","Ivanov","Ivanovich",LocalDate.of(1984, 7, 28),Gender.Male,1,1);
        Contract contr = new CellularContract(1,LocalDate.of(2010, 7, 28),LocalDate.of(2040, 7, 28),1,cli,1,1,1);
        ContractStore instance = new ContractStore();
        instance.addContract(contr);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContract method, of class ContractStore.
     */
    @Test
    public void testGetContract() {
        System.out.println("getContract");
        int id = 0;
        ContractStore instance = new ContractStore();        
        Client cli = new Client(1,"Ivan","Ivanov","Ivanovich",LocalDate.of(1984, 7, 28),Gender.Male,1,1);
        Contract contr = new CellularContract(1,LocalDate.of(2010, 7, 28),LocalDate.of(2040, 7, 28),1,cli,1,1,1);
        instance.addContract(contr);
        Contract result = instance.getContract(id);
        assertEquals(contr, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContractByID method, of class ContractStore.
     */
    @Test
    public void testGetContractByID() {
        System.out.println("getContractByID");
        int idcontr = 1;
        ContractStore instance = new ContractStore();        
        Client cli = new Client(1,"Ivan","Ivanov","Ivanovich",LocalDate.of(1984, 7, 28),Gender.Male,1,1);
        Contract contr = new CellularContract(1,LocalDate.of(2010, 7, 28),LocalDate.of(2040, 7, 28),1,cli,1,1,1);
        instance.addContract(contr);
        Contract result = instance.getContractByID(idcontr);
        assertEquals(contr, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContract method, of class ContractStore.
     */
    @Test
    public void testDeleteContract() {
        System.out.println("deleteContract");
        int id = 0;
        ContractStore instance = new ContractStore();
        instance.deleteContract(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteContractByID method, of class ContractStore.
     */
    @Test
    public void testDeleteContractByID() {
        System.out.println("deleteContractByID");
        int idcontr = 0;
        ContractStore instance = new ContractStore();
        instance.deleteContractByID(idcontr);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColCoctr method, of class ContractStore.
     */
    @Test
    public void testGetColCoctr() {
        System.out.println("getColCoctr");
        ContractStore instance = new ContractStore();
        int expResult = 1;
        Client cli = new Client(1,"Ivan","Ivanov","Ivanovich",LocalDate.of(1984, 7, 28),Gender.Male,1,1);
        Contract contr = new CellularContract(1,LocalDate.of(2010, 7, 28),LocalDate.of(2040, 7, 28),1,cli,1,1,1);
        instance.addContract(contr);
        int result = instance.getColCoctr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
