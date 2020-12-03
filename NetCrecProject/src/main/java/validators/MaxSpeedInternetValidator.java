package validators;

import ContractPackage.Contract;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Method;
import validators.Message.CheckStatus;

public class MaxSpeedInternetValidator implements Validator {

    @Override
    public Message validate(Contract contr) {
        try {
            Method method = contr.getClass().getMethod("getMaxSpeed");
            return ((double) method.invoke(contr) < 0)?
                new Message(CheckStatus.RedRisk,"maximum internet speed is less than 0"):
                ((double) method.invoke(contr) < 30)? 
                    new Message(CheckStatus.Error,"maximum internet speed is less than 30"):
                    new Message(CheckStatus.OK,""); 
            
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MaxSpeedInternetValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Message(CheckStatus.OK,"");
    }

    @Override
    public String getClassValidate() {
        return "InternetContract";
    }
   
    
}
