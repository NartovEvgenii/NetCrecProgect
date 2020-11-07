package SortedPackage;

import ContractPackage.Contract;
import java.util.Comparator;


public class SelectionSorter implements ISorted {

    @Override
    public void sort(Contract[] masContracts, Comparator<Contract> comp) {
        for (int i = 0; i < masContracts.length; i++) {
            int min = i;
            for (int j = i + 1; j < masContracts.length; j++) {
                if (comp.compare(masContracts[min], masContracts[j]) > 0) {
                    min = j;
                }
            }
            Contract temp = masContracts[i];
            masContracts[i] = masContracts[min];
            masContracts[min] = temp;
        }
    }

}
