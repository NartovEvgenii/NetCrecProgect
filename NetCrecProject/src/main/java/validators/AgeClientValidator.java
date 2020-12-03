package validators;

import ContractPackage.Contract;
import java.time.LocalDate;
import validators.Message.CheckStatus;

public class AgeClientValidator implements Validator  {

    /**
     * Method checks the age of the client of the contract for majority.
     *
     * @param contr - contract with the client 
     * @return - verification result message with verification status and error message
     */
    @Override
    public Message validate(Contract contr) {
        if(contr.getClient().getDateofBirth().isAfter(LocalDate.now())){
            return new Message(CheckStatus.RedRisk,"the client's date of birth is more than today");
        }
        return(contr.getClient().getAge() > 16)?
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.Error,"client's age is less than 16 years");
    }
    
}
