/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContractPackage;

import ContractPackage.Contract;
import SortedPackage.SelectionSorter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SelectionSorterTest {

    /**
     * Test of sort method, of class SelectionSorter.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("sort");
        ContractStore instance = new ContractStore();
        Client cli = new Client(1, "Ivan", "Ivanov", "Ivanovich", LocalDate.of(1984, 7, 28), Gender.Male, 1, 1);
        int[] masIndex = new int[]{12, 7, 1, 4};
        for (int i = 0; i < 4; i++) {
            Contract contr = new Contract(masIndex[i], LocalDate.of(2010, 7, 28), LocalDate.of(2040, 7, 28), 1, cli);
            instance.addContract(contr);
        }
        Arrays.sort(masIndex);
        SelectionSorter sorted = new SelectionSorter();
        Comparator<Contract> comp = (Contract o1, Contract o2) -> o1.getId() - o2.getId();
        sorted.sort(instance.getMasContracts(), comp);
        for (int i = 0; i < 4; i++) {
            assertEquals(masIndex[i], instance.getContract(i).getId());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
