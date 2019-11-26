package intro_to_java;

import static utils.IntegerValidation.readAndValidateInteger;


public class MaxDigit {

    public static void main(String[] args) {
        System.out.println("Enter an integer:");
        int number = readAndValidateInteger();
        if(number<0){
            number=(-number);
        }
        calculateMaxDigit(number);
    }

    /*
    The method save the digit, divides the number by 10 and compares the previous digit.
    It breaks when the number is 0.
     */
    private static void calculateMaxDigit(int number) {
        int maxDigit=0;

        while(true){
            int temp=number%10;
            if(temp>maxDigit) {
                maxDigit=temp;
            }

            if(number!=0){
                number/=10;
            }
            else{
                break;
            }
        }
        System.out.println("The maximum digit is:" + maxDigit);
    }
}
