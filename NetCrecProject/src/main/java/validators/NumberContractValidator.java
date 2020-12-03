package validators;

import ContractPackage.Contract;
import validators.Message.CheckStatus;

public class NumberContractValidator implements Validator{

    @Override
    public Message validate(Contract contr) {
        return(contr.getNumberContract() >= 0)?
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.RedRisk,"contract number less than 0"); 
    }
    
}
