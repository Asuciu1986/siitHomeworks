package exceptionsandlogging.customexceptions;

public class CustomBirthDateException extends Exception {

    public CustomBirthDateException() {
    }

    public CustomBirthDateException(String message) {
        super(message);
    }

    public CustomBirthDateException(String message, Throwable cause) {
        super(message, cause);
    }

}
