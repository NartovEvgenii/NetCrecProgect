package injectPackage;

public class InjectException extends Exception {
    
    public InjectException(String message){     
        super("Error occurred during dependency injection. Cause:" + message);
    }
}
