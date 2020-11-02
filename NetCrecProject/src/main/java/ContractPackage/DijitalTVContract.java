package ContractPackage;

import java.time.LocalDate;
import java.util.List;


public class DijitalTVContract extends Contract {
    
    private List<String> channelPackage;

    public DijitalTVContract(int id, LocalDate startDate, LocalDate endDate,int numberContract, Client client,List<String> channelPackage){
        super(id, startDate, endDate,numberContract, client);
        this.channelPackage = channelPackage;
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
