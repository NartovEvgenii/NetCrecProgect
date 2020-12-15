package validators;

import ContractPackage.Contract;
import injectPackage.MyInject;
import injectPackage.MyInjector;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContractValidator implements Validator {
    
    @MyInject
    List<Validator> validators;
    /*static {        
        validators.add(new NumberContractValidator());
        validators.add(new DateContractValidator());
        validators.add(new FioClientValidator());
        validators.add(new AgeClientValidator());
        validators.add(new PassportClientValidator());
        validators.add(new MinGBSmsCellurarValidator());
        validators.add(new MaxSpeedInternetValidator());
        validators.add(new ChannelPackageValidator());              
    }*/
    {
        try { 
            MyInjector.injectorValidateAndCreate(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    

    /**
     * Method checks the contract for data correctness.
     *
     * @param contr - verifiable contract 
     * @return - verification result message with verification status and error message
     */
    @Override
    public Message validate(Contract contr) {
        Message res = new Message(Message.CheckStatus.OK,"");
        for(Validator val : validators){   
            if(contr.getClass().getSimpleName().equals(val.getClassValidate()) || 
                contr.getClass().getSuperclass().getSimpleName().equals(val.getClassValidate())){
                Message mess = val.validate(contr);                
                if(!mess.getStatus().equals(Message.CheckStatus.OK)){
                    if(!res.getStatus().equals(Message.CheckStatus.RedRisk)){
                        if(!mess.getStatus().equals(Message.CheckStatus.Error)){
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
