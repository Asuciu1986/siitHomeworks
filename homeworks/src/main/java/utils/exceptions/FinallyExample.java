package utils.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FinallyExample {

    public static void main(String[] args) {

        try{
            System.out.println("Beginning of try");

            if(1 > 0){

                throw new RuntimeException("message");
            }
            //aaa();

            System.out.println("End of try");
            return;
        }catch(RuntimeException e){
//            e.printStackTrace();
            log.error(e.getMessage(), e);
            System.out.println("Inside catch");
        }finally {
            System.out.println("Inside finally");
        }
    }

    static void aaa (){
        String str = null;
//        str.trim();
        Integer.parseInt("aaa");
    }

}
