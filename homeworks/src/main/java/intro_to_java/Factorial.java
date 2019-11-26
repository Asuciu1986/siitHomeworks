package intro_to_java;


import static utils.IntegerValidation.readAndValidateInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println("Enter the factorial integer number:");
        int number = readAndValidateInteger();
        System.out.println("Factorial of " + number + " is " + calculateFactorial(number));
    }

    private static int calculateFactorial(int number){

        if(number==0||number==1){
            return number;
        }
        return number*calculateFactorial(number-1);
    }
}
