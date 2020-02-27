package utils.exceptions;

public class CustomCheckedException extends Exception {

    public CustomCheckedException(){
        super();
    }

    public CustomCheckedException(String msg){
        super(msg);
    }

    public CustomCheckedException(String msg, Throwable tr){
        super(msg, tr);
    }
}
