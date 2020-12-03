package validators;

import ContractPackage.Contract;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinGBSmsCellurarValidator implements Validator {

    @Override
    public Message validate(Contract contr) {
        String err = "";
        try {
            Method min_method = contr.getClass().getMethod("getColMinutes");
            Method gb_method = contr.getClass().getMethod("getColGigabytes");
            Method sms_method = contr.getClass().getMethod("getColSms");            
            if((int) min_method.invoke(contr) < 0){
               err += " the number of minutes in the contract is less than 0."; 
            }
            if((int) gb_method.invoke(contr) < 0){
               err += " the number of gigabytes in the contract is less than 0."; 
            }
            if((int) sms_method.invoke(contr) < 0){
               err += " the number of SMS in the contract is less than 0."; 
            }
            
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MaxSpeedInternetValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return err.equals("")?
            new Message(Message.CheckStatus.OK,"") :
            new Message(Message.CheckStatus.RedRisk,err); 
    }

    @Override
    public String getClassValidate() {
        return "CellularContract";
    }
    
}
