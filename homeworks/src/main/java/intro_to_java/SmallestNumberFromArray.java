package intro_to_java;

import utils.ArrayInitialization;

/*
reads an array from the keyboard
performs validation for each element to be INTEGER
returns the smallest number of the array
 */
public class SmallestNumberFromArray {

    public static void main(String[] args) {
        int[] numbersArray= ArrayInitialization.initializeAndReturnArray();

        System.out.println("The smallest integer number from the given array is: " + returnSmallestNumberFor(numbersArray));
        System.out.println("The smallest integer number from the given array is: " + returnSmallestNumberForEach(numbersArray));
    }

    /*
    This method returns the smallest number from an array using a for loop
     */
    private static int returnSmallestNumberFor(int[] numbersArray){
        int smallestNumber = numbersArray[0];
        for(int i=1;i<numbersArray.length;i++){

            if(numbersArray[i]<smallestNumber){
                smallestNumber = numbersArray[i];
            }
        }
        return smallestNumber;
    }


    /*
    This method returns the smallest number from an array using a for each loop
     */
    private static int returnSmallestNumberForEach(int[] numbersArray){
        int smallestNumber = numbersArray[0];
        for(int number:numbersArray){

            if(number<smallestNumber){
                smallestNumber=number;
            }
        }
        return smallestNumber;
    }

}
