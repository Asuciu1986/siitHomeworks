package intro_to_java;

import static utils.IntegerValidation.readAndValidateInteger;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        System.out.println("This app displays the prime numbers until a given number.");
        System.out.println("Please enter the integer value of the upper bound:");
        //Scanner scanner = new Scanner(System.in);
        int number = readAndValidateInteger();

        if(number<=1){
            System.out.println("No prime numbers in this range. You entered an upper bound smaller than 2. The first prime number is 2.");
            return;
        }

        System.out.println("The list of prime numbers below " + number + ":");
        for(int i=2;i<number;i++){
            if(checkIfPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean checkIfPrime(int number){
        if(number==0||number==1){
            return false;
        }
        for(int i=2;i<=number/2;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
