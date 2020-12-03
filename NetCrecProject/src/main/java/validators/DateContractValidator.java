package validators;

import ContractPackage.Contract;
import validators.Message.CheckStatus;

public class DateContractValidator implements Validator {
    
    @Override
    public Message validate(Contract contr) {
        return(contr.getStartDate().isBefore(contr.getEndDate()))?
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.RedRisk,"the start date of the contract is after the end date of the contract");  
    }
    
}
