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
     * @return - list of connected channel packages
     */
    public List<String> getChannelPackage() {
        return channelPackage;
    }

    /**
     * replace list of connected channel packages
     * @param channelPackage - new list of connected channel packages
     */
    public void setChannelPackage(List<String> channelPackage) {
        this.channelPackage = channelPackage;
    }
}
