package test;

public class ExceptionFinally {

    public static void main(String[] args) {

        try{
            verificareFinal();

        }
        finally {
            System.out.println("jos");
        }
    }

    public static void verificareFinal(){

        try{
            int a = 100/0;
        }

        finally {
            System.out.println("sus");
        }
    }
}
