package intro_to_java;

public class ArrayDeleteDuplicatesWithoutSort extends ArrayDeleteDuplicatesBase {

    //This method prints the number of unique elements of the array.
    //It is the same as the main method for printing distinct array by avoiding using Arrays class and sorting

    public int[] deleteDuplicates(int[] numbersArray){
        int nrUniqueElements = getNumberOfDistinctElements(numbersArray);
        //System.out.println(getUniqueNumberOfElements(numbersArray));
        int[] newNumbersArray = new int[nrUniqueElements];
        calculateNewArray(numbersArray,newNumbersArray);
        return newNumbersArray;
    }

    //this method returns the number of distinct elements from an array


    //this method calculates the array without duplicates
    public static void calculateNewArray(int[] numbersArray, int[] newNumbersArray){
        newNumbersArray[0]=numbersArray[0];
        int counter=1;
        for(int i=1;i<numbersArray.length;i++) {
            boolean exists = false;

            for(int j=0;j<newNumbersArray.length;j++) {

                if(numbersArray[i]==newNumbersArray[j]){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                newNumbersArray[counter++]=numbersArray[i];
            }
        }
    }
}
