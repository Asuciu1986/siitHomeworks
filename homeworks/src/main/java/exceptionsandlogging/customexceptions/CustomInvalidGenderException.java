package exceptionsandlogging.customexceptions;

public class CustomInvalidGenderException extends Exception {

    public CustomInvalidGenderException() {
    }

    public CustomInvalidGenderException(String message) {
        super(message);
    }

    public CustomInvalidGenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomInvalidGenderException(Throwable cause) {
        super(cause);
    }
}
