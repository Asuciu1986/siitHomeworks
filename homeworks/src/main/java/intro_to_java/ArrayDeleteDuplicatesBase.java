package intro_to_java;

import utils.ArrayInitialization;
import java.util.Arrays;

public abstract class ArrayDeleteDuplicatesBase {

    public int[] initialArray;
    public int[] finalArray;

    public ArrayDeleteDuplicatesBase(){

        this.initialArray=ArrayInitialization.initializeAndReturnArray();
    }

    public abstract int[] deleteDuplicates(int[] initialArray);

    public static int getNumberOfDistinctElements(int[] numbersArray){

        int counter=0;

        for(int i=0;i<numbersArray.length;i++) {
            boolean isUnique=true;

            for(int j=i+1;j<numbersArray.length;j++){
                if(numbersArray[i]==numbersArray[j]){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique) {
                counter += 1;
            }
        }
        return counter;
    }

    public String toString(){
        return Arrays.toString(finalArray);
    }


}
