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

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
