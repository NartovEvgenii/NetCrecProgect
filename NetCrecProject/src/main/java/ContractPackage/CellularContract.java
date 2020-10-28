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

    public int getColMinutes() {
        return colMinutes;
    }

    public void setColMinutes(int colMinutes) {
        this.colMinutes = colMinutes;
    }

    public int getColGigabytes() {
        return colGigabytes;
    }

    public void setColGigabytes(int colGigabytes) {
        this.colGigabytes = colGigabytes;
    }

    public int getColSms() {
        return colSms;
    }

    public void setColSms(int colSms) {
        this.colSms = colSms;
    }
}
