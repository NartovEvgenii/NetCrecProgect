package ContractPackage;

import java.time.LocalDate;

public class CellularContract implements Contract {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private int colMinutes;
    private int colGigabytes;
    private int colSms;

    public CellularContract(int id, LocalDate startDate, LocalDate endDate, Client client,int colMinutes,int colGigabytes,int colSms) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.colMinutes = colMinutes;
        this.colGigabytes = colGigabytes;
        this.colSms = colSms;
    }

    /**
     * @return - ID of the contract
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
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
     * @return - number of minutes provided
     */
    public int getColMinutes() {
        return colMinutes;
    }

    /**
     * replace number of minutes provided
     * @param colMinutes - new number of minutes provided
     */
    public void setColMinutes(int colMinutes) {
        this.colMinutes = colMinutes;
    }

    /**
     * @return - number of gigabytes of Internet provided
     */
    public int getColGigabytes() {
        return colGigabytes;
    }

    /**
     * replace number of gigabytes of Internet provided
     * @param colGigabytes - new number of gigabytes of Internet provided
     */
    public void setColGigabytes(int colGigabytes) {
        this.colGigabytes = colGigabytes;
    }

    /**
     * @return - number of provided SMS
     */
    public int getColSms() {
        return colSms;
    }

    /**
     * replace number of provided SMS
     * @param colSms - new number of provided SMS
     */
    public void setColSms(int colSms) {
        this.colSms = colSms;
    }
}
