package validators;

import ContractPackage.Contract;

public class FioClientValidator implements Validator {

    /**
     * Method checks for uppercase name, surname and patronymic of the client of the contract.
     *
     * @param contr - contract with the client 
     * @return - verification result message with verification status and error message
     */
    @Override
    public Message validate(Contract contr) {
        String err = "";
        if(Character.isLowerCase(contr.getClient().getName().charAt(0))){
            err +="name ";
        }
        if(Character.isLowerCase(contr.getClient().getSurname().charAt(0))){
            err +="surname ";
        }
        if(Character.isLowerCase(contr.getClient().getPatronymic().charAt(0))){
            err +="patronymic ";
        }
        return err.equals("")?
            new Message(Message.CheckStatus.OK,"") :
            new Message(Message.CheckStatus.Error,err + "of the client start with a small letter"); 
    }
    
}
