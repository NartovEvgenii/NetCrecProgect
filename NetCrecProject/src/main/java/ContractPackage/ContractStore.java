package ContractPackage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ContractStore {

    private Contract[] masContracts;
    private int colContr;

    public ContractStore() {
        masContracts = new Contract[100];
        colContr = 0;
    }

    private void redactMas() {
        int newLength =colContr + Math.min(colContr, 10000);
        masContracts = Arrays.copyOf(masContracts, newLength);
        colContr +=1;
    }

    
    public void addContract(Contract contr) {
        if (masContracts.length <= colContr) {
            redactMas();
        }
        masContracts[colContr]=contr;
        colContr +=1;
    }
    public Contract getContract(int id) {
        return masContracts[id];
    }
    public Contract getByIDContract(int id) {
        for(int i=0;i<colContr){
            
        }{
            
        }
        return null;
    }

    public int getColCoctr() {
        return colContr;
    }

}
