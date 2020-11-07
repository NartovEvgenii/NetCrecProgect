package SortedPackage;

import ContractPackage.Contract;
import java.util.Comparator;

public class BubbleSorter implements ISorted {

    /**
     * Method sorts the array of contracts by criterion
     * @param masContracts - array to sort
     * @param comp - comparator sort criterion
     */
    @Override
    public void sort(Contract[] masContracts, Comparator<Contract> comp) {
        for (int i = 0; i < masContracts.length - 1; i++) {
            for (int j = i; j < masContracts.length - 1; j++) {
                if (comp.compare(masContracts[i], masContracts[i+1]) > 0) {
                    Contract temp = masContracts[i];
                    masContracts[i+1] = masContracts[i];
                    masContracts[i] = temp;
                }
            }
        }
    }

}
