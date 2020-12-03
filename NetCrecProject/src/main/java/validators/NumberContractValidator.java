package validators;

import ContractPackage.Contract;
import validators.Message.CheckStatus;

public class NumberContractValidator implements Validator{

    /**
     * Method checks the contract number for correctness.
     *
     * @param contr - verifiable contract 
     * @return - verification result message with verification status and error message
     */
    @Override
    public Message validate(Contract contr) {
        return(contr.getNumberContract() >= 0)?
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.RedRisk,"contract number less than 0"); 
    }
    
}
