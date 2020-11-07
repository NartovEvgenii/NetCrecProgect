package ContractPackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Predicate;

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
        masContracts = Arrays.copyOf(getMasContracts(), newLength);
    }

    /**
     * Method for adding a contract to an array.
     *
     * @param contr - contract to add
     */
    public void addContract(Contract contr) {
        if (getMasContracts().length <= colContr) {
            redactMas();
        }
        masContracts[colContr] = contr;
        colContr += 1;
    }

    /**
     * Method returns the contract by location in the array.
     *
     * @param id - location in the array
     * @return - Contract
     */
    public Contract getContract(int id) {
        if (id < colContr) {
            return getMasContracts()[id];
        }
        return null;
    }

    /**
     * Method returns the contract by ID of the contract. *
     *
     * @param idcontr - ID of the contract
     * @return - Contract
     */
    public Contract getContractByID(int idcontr) {
        for (int i = 0; i < colContr; i++) {
            if (getMasContracts()[i].getId() == idcontr) {
                return getMasContracts()[i];
            }
        }
        return null;
    }

    /**
     * Method removes the contract by location in the array.
     *
     * @param id - location in the array
     */
    public void deleteContract(int id) {
        if (id < colContr) {
            for (int i = id; i < colContr - 1; i++) {
                masContracts[i] = getMasContracts()[i + 1];
            }
            masContracts[colContr] = null;
            colContr -= 1;
        }
    }

    /**
     * Method removes the contract by ID of the contract.
     *
     * @param idcontr - ID of the contract
     */
    public void deleteContractByID(int idcontr) {
        boolean check = false;
        for (int i = 0; i < colContr; i++) {
            if (getMasContracts()[i].getId() == idcontr) {
                check = true;
            }
            if (check) {
                if (i < colContr - 1) {
                    masContracts[i] = getMasContracts()[i + 1];
                } else {
                    masContracts[i] = null;
                    colContr -= 1;
                }
            }
        }
    }

    /**
     * Method returns the number of contracts in the array.
     *
     * @return - number of contracts
     */
    public int getColCoctr() {
        return colContr;
    }

    /**
     * Returns an array of contracts
     *
     * @return - array of contracts
     */
    public Contract[] getMasContracts() {
        return masContracts;
    }

    /**
     * Rreturns an array of sorted items by parameter
     *
     * @param pred - contract sorting option
     * @return - array of contracts
     */
    public Contract[] findBy(Predicate<Contract> pred) {
        ContractStore result = new ContractStore();
        for (int i = 0; i < colContr; i++) {
            if (pred.test(masContracts[i])) {
                result.addContract(masContracts[i]);
            }
        }
        return result.getMasContracts();
    }

}
