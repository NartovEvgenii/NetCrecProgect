package validators;

import ContractPackage.Contract;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChannelPackageValidator implements Validator {

    @Override
    public Message validate(Contract contr) {
        try {
            Method list_contract_method = contr.getClass().getMethod("getChannelPackage");
            List<String> chanell = (List<String>) list_contract_method.invoke(contr);
            if(chanell.isEmpty()){
                return new Message(Message.CheckStatus.RedRisk,"the package does not contain channels");
            } else if(chanell.size() < 2){
                return new Message(Message.CheckStatus.Error,"the number of channels in the package is less than 2");
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MaxSpeedInternetValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Message(Message.CheckStatus.OK,"");
    }

    @Override
    public String getClassValidate() {
        return "DijitalTVContract";
    }
    
}
