package ContractPackage;

import java.time.LocalDate;
import java.util.List;


public class DijitalTVContract implements Contract {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private List<String> channelPackage;

    public DijitalTVContract(int id, LocalDate startDate, LocalDate endDate, Client client,List<String> channelPackage){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.channelPackage = channelPackage;
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

    public List<String> getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(List<String> channelPackage) {
        this.channelPackage = channelPackage;
    }
}
