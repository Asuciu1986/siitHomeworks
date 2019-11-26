package intro_to_java;

public class SumOfFirstNumbers {

    public static void main(String[] args) {
        int highestNumber = 100;
        int result= sumOfFirstNumbers(highestNumber);

        //uncomment line below and comment int result= sumOfFirstNumbers(highestNumber); for the version with algebraic formula n(n+1)/2
        //int result=sumOfFirstNumbersWithFormula(highestNumber);

        System.out.println("The sum of the first 100 numbers higher than 0 is: " + result);

    }
    /*
    This method receives the highest number and returns the sum of all numbers between [1,highestNumber]
     */
    private static int sumOfFirstNumbers(int highestNumber){
        //method recursively returns the sum of the numbers between 0 the value of highestNumber
        if(highestNumber==1)
            return 1;

        return highestNumber + (sumOfFirstNumbers(highestNumber-1));
    }

    //This method applies the algebraic formula to return the sum of the numbers
    private static int sumOfFirstNumbersWithFormula(int highestNumber){
        return highestNumber*(highestNumber+1)/2;
    }
}
