package utils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Testare {

    public static void main(String[] args){

        FileReader rd = null;

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
