package utils.exceptions;

public class CustomUncheckedException extends RuntimeException {

    public CustomUncheckedException(){
        super();
    }

    public CustomUncheckedException(String msg){
        super(msg);
    }

    public CustomUncheckedException(String msg, Throwable tr){
        super(msg, tr);
    }

}
