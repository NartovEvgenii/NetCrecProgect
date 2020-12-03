package validators;



public class Message {

    public enum CheckStatus {
        OK,
        Error,
        RedRisk
    }
    
    private String errorMessage = "";
    private CheckStatus status = CheckStatus.OK;
    
    public Message(CheckStatus status,String errorMessage){
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CheckStatus getStatus() {
        return status;
    }

    public void setStatus(CheckStatus status) {
        this.status = status;
    }
}
