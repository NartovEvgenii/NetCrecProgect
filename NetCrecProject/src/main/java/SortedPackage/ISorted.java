package SortedPackage;

import ContractPackage.Contract;
import java.util.Comparator;

public interface ISorted {

    void sort(Contract[] masContracts, Comparator<Contract> comp);

    /**
     * Method returns the values of the standard comparator, taking NULL as the maximum value.
     * @param contr1 - first contract
     * @param contr2 - second contract
     * @param comp - comparator sort criterion
     * @return - 0 if both contracts are null, 1 if first contract is not null,-1 if second contract is not null
     */
    public static int checkCompWithNull(Contract contr1, Contract contr2, Comparator<Contract> comp) {        
        if (contr1 != null && contr2 != null) {
                return comp.compare(contr1, contr2);
            } else {
                if (contr1 != null || contr2 != null) {
                    return contr1 != null ? -1 : 1;
                } else {
                    return 0;
                }
            }
    }
}
