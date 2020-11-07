package SortedPackage;

import ContractPackage.Contract;
import java.util.Comparator;

public interface ISorted {

    void sort(Contract[] masContracts,Comparator<Contract> comp);
}
