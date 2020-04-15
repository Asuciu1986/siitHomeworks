package utils;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Testare {

    public static void main(String[] args){

        Om om1 = new Contabil();
        Om om2 = new Programator();
        Om om3 = new Programator();
        Om om4 = new Programator();
        Om om5 = new Contabil();

        List<Om> lista = new ArrayList<>();
        lista.add(om1);
        lista.add(om2);
        lista.add(om3);
        lista.add(om4);
        lista.add(om5);

        Iterator<Om> it = lista.iterator();

        while(it.hasNext()){
            Om om = it.next();
            if(om instanceof Programator)
                System.out.println(om);
        }

        FileReader rd = null;

        String fileName = LocalDate.now().format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd")) + "-" + (LocalTime.now().getHour()-1) + "TradeCaptureRprt.csv";

        System.out.println(fileName);

        try{
            rd =  new FileReader(new File("D:\\GitHubSiit\\siitHomeworks\\homeworks\\src\\main\\java\\utils\\exceptions\\ceva.txt"));
            try{
                int[] array = new int[5];
                System.out.println(array[5]);
            } catch (ArrayIndexOutOfBoundsException ae){
                System.out.println(ae.getMessage());
            }
            try {
                int x = 50/0;
            } catch (Exception are){
                System.out.println(are.getMessage());
            }

        } catch (FileNotFoundException e){
            System.out.println("Am prins-o pe asta");
        }
    }
}
