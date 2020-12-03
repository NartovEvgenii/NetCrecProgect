package validators;

import ContractPackage.Contract;

public interface Validator {
    
    public Message validate(Contract contr);
    
    default String getClassValidate(){
        return "Contract";
    }
    
}
