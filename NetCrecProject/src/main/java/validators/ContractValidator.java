package validators;

import ContractPackage.Contract;
import java.util.ArrayList;
import java.util.List;

public class ContractValidator implements Validator {
    
    static List<Validator> validators =new ArrayList();
    static {
        validators.add(new NumberContractValidator());
        validators.add(new DateContractValidator());
        validators.add(new FioClientValidator());
        validators.add(new AgeClientValidator());
        validators.add(new PassportClientValidator());
        validators.add(new MinGBSmsCellurarValidator());
        validators.add(new MaxSpeedInternetValidator());
        validators.add(new ChannelPackageValidator());              
    }

    @Override
    public Message validate(Contract contr) {
        Message res = new Message(Message.CheckStatus.OK,"");
        for(Validator val : validators){
            if(contr.getClass().getSimpleName().equals(val.getClassValidate()) || 
                contr.getClass().getSuperclass().getSimpleName().equals(val.getClassValidate())){
                Message mess = val.validate(contr);
                if(mess.getStatus() != Message.CheckStatus.OK){
                    if(res.getStatus() != Message.CheckStatus.RedRisk){
                        if(mess.getStatus() == Message.CheckStatus.Error){
                            res.setStatus(Message.CheckStatus.Error);
                        }else{
                            res.setStatus(Message.CheckStatus.RedRisk);
                        }
                    }
                    res.setErrorMessage(res.getErrorMessage()+" \n " + mess.getErrorMessage());
                }
            }
        }   
        return res;
    }
}
