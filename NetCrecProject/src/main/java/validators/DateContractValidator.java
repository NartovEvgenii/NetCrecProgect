package validators;

import ContractPackage.Contract;
import validators.Message.CheckStatus;

public class DateContractValidator implements Validator {
    
    /**
     * Method to check the creation date of the contract was before the date of its completion.
     *
     * @param contr - verifiable contract 
     * @return - verification result message with verification status and error message
     */
    @Override
    public Message validate(Contract contr) {
        return(contr.getStartDate().isBefore(contr.getEndDate()))?
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.RedRisk,"the start date of the contract is after the end date of the contract");  
    }
    
}
