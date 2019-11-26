package utils;

import static utils.IntegerValidation.readAndValidateInteger;

public class ArrayInitialization {

    /*
    This method read an integer array from keyboard.
    It makes the integer validation with the help of
    IntegerValidation.readAndValidateInteger
     */
    public static int[] initializeAndReturnArray(){

        System.out.println("Enter the number of elements for the array. It has to be an integer higher than 0:");

        int arrayLength = readAndValidateInteger();
        while(arrayLength<1) {
            System.out.println("The length of the array should be greater than zero. Re-enter the integer:");
            arrayLength = readAndValidateInteger();
        }

        int[] numbersArray=new int[arrayLength];
        System.out.println("Enter the integer elements of the array pressing ENTER after each number:");

        for(int i=0;i<arrayLength;i++){
            numbersArray[i]=readAndValidateInteger();
            //System.out.println(numbersArray[i]);
        }

        return numbersArray;
    }
}
