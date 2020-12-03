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

    /**
     * Method returns error text.
     *
     * @return - error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Method replaces error text.
     *
     * @param errorMessage - new error text
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Method returns error status.
     *
     * @return - error status
     */
    public CheckStatus getStatus() {
        return status;
    }

    /**
     * Method replaces error status.
     *
     * @param status - new error status
     */
    public void setStatus(CheckStatus status) {
        this.status = status;
    }
}
