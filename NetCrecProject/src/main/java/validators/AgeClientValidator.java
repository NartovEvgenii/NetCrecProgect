package validators;

import ContractPackage.Contract;
import java.time.LocalDate;
import validators.Message.CheckStatus;

public class AgeClientValidator implements Validator  {

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
