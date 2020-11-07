package SortedPackage;

import ContractPackage.Contract;
import static SortedPackage.ISorted.checkCompWithNull;
import java.util.Comparator;

public class BubbleSorter implements ISorted {

    /**
     * Method sorts the array of contracts by criterion
     *
     * @param masContracts - array to sort
     * @param comp - comparator sort criterion
     */
    @Override
    public void sort(Contract[] masContracts, Comparator<Contract> comp) {
        for (int i = 0; i < masContracts.length - 1; i++) {
            for (int j = masContracts.length - 1; j > i; j--) {
                if (checkCompWithNull(masContracts[j - 1],masContracts[j],comp) > 0) {
                    Contract temp = masContracts[j - 1];
                    masContracts[j - 1] = masContracts[j];
                    masContracts[j] = temp;
                }
            }
        }
    }
    

}
