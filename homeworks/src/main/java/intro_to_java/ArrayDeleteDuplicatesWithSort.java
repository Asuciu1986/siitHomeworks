package intro_to_java;

import java.util.Arrays;

public class ArrayDeleteDuplicatesWithSort extends ArrayDeleteDuplicatesBase {

    public int[] deleteDuplicates(int[] numbersArray){
        Arrays.sort(numbersArray);
        int finalArrayLength=getNumberOfDistinctElements(numbersArray);
        System.out.println(finalArrayLength);
        int[] finalArray = new int[finalArrayLength];
        int j = 0;
        for (int i=0; i<numbersArray.length-1; i++)
            if (numbersArray[i] != numbersArray[i+1])
                finalArray[j++] = numbersArray[i];

        finalArray[j] = numbersArray[numbersArray.length-1];

        return finalArray;
    }
}
