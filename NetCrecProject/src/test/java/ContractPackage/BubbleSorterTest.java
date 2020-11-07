package ContractPackage;

import SortedPackage.BubbleSorter;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSorterTest {

    /**
     * Test of sort method, of class BubbleSorter.
     */
    @Test
    public void testBubbleSort() {
        System.out.println("sort");
        ContractStore instance = new ContractStore();
        Client cli = new Client(1, "Ivan", "Ivanov", "Ivanovich", LocalDate.of(1984, 7, 28), Gender.Male, 1, 1);
        int[] masIndex = new int[]{12, 7, 1, 4};
        for (int i = 0; i < 4; i++) {
            Contract contr = new Contract(masIndex[i], LocalDate.of(2010, 7, 28), LocalDate.of(2040, 7, 28), 1, cli);
            instance.addContract(contr);
        }
        Arrays.sort(masIndex);
        BubbleSorter sorted = new BubbleSorter();
        Comparator<Contract> comp = (Contract o1, Contract o2) ->o1.getId() - o2.getId();
        sorted.sort(instance.getMasContracts(), comp);
        for (int i = 0; i < 4; i++) {
            assertEquals(masIndex[i], instance.getContract(i).getId());
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
