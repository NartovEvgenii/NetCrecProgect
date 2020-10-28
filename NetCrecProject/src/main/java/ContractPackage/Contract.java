package ContractPackage;

import java.time.LocalDate;

public interface Contract {
    
    int getId();
    
    LocalDate getStartDate();
    
    LocalDate getEndDate();
    
    Client getClient();
}
