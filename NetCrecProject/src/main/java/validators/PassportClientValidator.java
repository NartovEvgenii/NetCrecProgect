package validators;

import ContractPackage.Contract;
import validators.Message.CheckStatus;

public class PassportClientValidator implements Validator {

    @Override
    public Message validate(Contract contr) {
        String err = "";
        if((int) (Math.log10(contr.getClient().getPassportSerial()) + 1) != 4){
            err = "the number of digits in the client's passport series is not 4.";
        }
        if((int) (Math.log10(contr.getClient().getPassportNum()) + 1) != 6){
            err = "the number of digits in the client's passport number is not 6.";
        }
        return(err.equals(""))? 
            new Message(CheckStatus.OK,"") :
            new Message(CheckStatus.RedRisk,err);
    }
    
}
