package ContractPackage;

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
        Contract contr = null;
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
        Contract expResult = null;
        Contract result = instance.getContract(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContractByID method, of class ContractStore.
     */
    @Test
    public void testGetContractByID() {
        System.out.println("getContractByID");
        int idcontr = 0;
        ContractStore instance = new ContractStore();
        Contract expResult = null;
        Contract result = instance.getContractByID(idcontr);
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
        int expResult = 0;
        int result = instance.getColCoctr();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
