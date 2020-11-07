package SortedPackage;

import ContractPackage.Contract;
import java.util.Comparator;

public interface ISorted {

    void sort(Contract[] masContracts, Comparator<Contract> comp);

    public static int checkCompWithNull(Contract o1, Contract o2, Comparator<Contract> comp) {        
        if (o1 != null && o2 != null) {
                return comp.compare(o1, o2);
            } else {
                if (o1 != null || o2 != null) {
                    return o1 != null ? -1 : 1;
                } else {
                    return 0;
                }
            }
    }
}
