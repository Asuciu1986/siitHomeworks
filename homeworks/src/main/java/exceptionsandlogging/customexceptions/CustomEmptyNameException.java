package exceptionsandlogging.customexceptions;

public class CustomEmptyNameException extends Exception{

    public CustomEmptyNameException() {
    }

    public CustomEmptyNameException(String message) {
        super(message);
    }

    public CustomEmptyNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomEmptyNameException(Throwable cause) {
        super(cause);
    }
}
