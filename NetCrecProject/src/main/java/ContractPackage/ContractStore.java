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
    
    /**
     * Array length extension method.
     */
    private void redactMas() {
        int newLength = colContr + Math.min(colContr, 10000);
        masContracts = Arrays.copyOf(masContracts, newLength);
    }
    
    /**
     * Method for adding a contract to an array.
     * @param contr - contract to add
     */
    public void addContract(Contract contr) {
        if (masContracts.length <= colContr) {
            redactMas();
        }
        masContracts[colContr] = contr;
        colContr += 1;
    }
    
    public Contract getContract(int id) {
        if (id < colContr) {
            return masContracts[id];
        }
        return null;
    }

    public Contract getContractByID(int idcontr) {
        for (int i = 0; i < colContr; i++) {
            if (masContracts[i].getId() == idcontr) {
                return masContracts[i];
            }
        }
        return null;
    }

    public void deleteContract(int id) {
        if (id < colContr) {
            for (int i = id; i < colContr - 1; i++) {
                masContracts[i] = masContracts[i + 1];
            }
            masContracts[colContr] = null;
            colContr -=1;
        }
    }

    public void deleteContractByID(int idcontr) {
        boolean check = false;
        for (int i = 0; i < colContr; i++) {
            if (masContracts[i].getId() == idcontr) {
                check = true;
            }
            if (check) {
                if (i < colContr - 1) {
                    masContracts[i] = masContracts[i + 1];
                } else {
                    masContracts[i] = null;
                    colContr -=1;
                }
            }
        }
    }

    public int getColCoctr() {
        return colContr;
    }

}
