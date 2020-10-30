package ContractPackage;

import java.time.LocalDate;


public class InternetContract implements Contract{
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private double maxSpeed;

    public InternetContract(int id, LocalDate startDate, LocalDate endDate, Client client,double maxSpeed){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.maxSpeed = maxSpeed;
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
     * @return - maximum internet speed
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * replace maximum internet speed
     * @param maxSpeed - new maximum internet speed
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
