package ContractPackage;

import java.time.LocalDate;

public class Contract {
    
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberContract;
    private Client client;

    public Contract(int id, LocalDate startDate, LocalDate endDate,int numberContract, Client client) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberContract = numberContract;
        this.client = client;
    }
    /**
     * @return - ID of the contract
     */
    public int getId() {
        return id;
    }

    /**
     * replace ID of the contract
     * @param id - new ID of the contract
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return - start date of the contract
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * replace start date of the contract
     * @param startDate - new start date of the contract
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return - contract expiration date
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * replace contract expiration date
     * @param endDate - new contract expiration date
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @return - client of the contract
     */
    public Client getClient() {
        return client;
    }

    /**
     * replace client of the contract
     * @param client - client of the contract
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return - number of the contract
     */
    public int getNumberContract() {
        return numberContract;
    }

    /**
     * replace number of the contract
     * @param numberContract - new number of the contract
     */
    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }
}
