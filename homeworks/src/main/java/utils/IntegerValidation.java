package utils;

import java.util.Scanner;



public class IntegerValidation {
    /*
    static method eadAndValidateTheNrOfArrayElements
    reads, validates as integer and returns it
    */
    public static int readAndValidateInteger(){

        Scanner scanner = new Scanner(System.in);
        int number;

        while(!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("This is not an integer. Please re-enter the integer:");

        }
        number = scanner.nextInt();

        return number;

//
//        while(true) {
//            try {
//                scanner = new Scanner(System.in);
//                number = scanner.nextInt();
//                scanner.nextLine();
//
//
//                break;
//            }
//
//            catch (InputMismatchException e) {
//                System.out.println("This is not an integer. Please re-enter the integer:");
//            }
//
//        }

    }

}
