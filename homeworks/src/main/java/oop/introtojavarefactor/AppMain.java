package oop.introtojavarefactor;

import java.util.Arrays;
import java.util.Scanner;

import static utils.IntegerValidation.readAndValidateInteger;

public class AppMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //read number for which to calculate the sum of first numbers until that number
        printDescription("This app returns the sum of the first numbers smaller or equal to the number provided");
        int number = getANumberFromKeyboard(scanner,"Enter an integer number for which to calculate the sum of numbers smaller " +
                "than equal to that number:");
        System.out.println("The sum of the fist numbers smaller and equal to " + number + " is:" + sumOfFirstNumbers(number));

        //read an array for which to calculate the smallest number
        printDescription("This app return the smallest number from an array");
        int[] numbersArray = initializeAndReturnArray(scanner);
        System.out.println("The smallest number from the array using a for is:" + returnSmallestNumberFor(numbersArray));
        System.out.println("The smallest number from the array using a foreach is:" + returnSmallestNumberForEach(numbersArray));

        //read an integer for which to return the highest digit
        printDescription("This app returns the highest digit from an integer number");
        System.out.println("Please enter the integer:");
        int numberForHighestDigit = readAndValidateInteger(scanner);
        System.out.println("The highest digit is:" + calculateMaxDigit(numberForHighestDigit));

        //read the number that you want to determine if it is a palindrome
        printDescription("This app determines if an integer number is a palindrome");
        System.out.println("Please enter the integer to check if it is a palindrome:");
        String possiblePalindrome = Integer.toString(readAndValidateInteger(scanner));
        boolean isPalindrome = checkIfPalindromeWithString(possiblePalindrome);
        if(isPalindrome){
            System.out.println("The number is a palindrome");
        }
        else{
            System.out.println("The number is not a palindrome");
        }

        //display all prime numbers until a given number
        printDescription("This app displays all prime numbers until a given number");
        printPrimeNumbers(scanner);
        System.out.println();


        //calculator continous
        printDescription("This app calculates different arithmetical operations until the user chooses to stop");
        calculateContinuous(scanner);

        //calculator using if else
        printDescription("This app calculates different arithmetical operations between two numbers");
        calculate(scanner);

        //calculator of the factorial of a number
        printDescription("This app calculates the factorial of a number");
        System.out.println("Please enter the integer number for which you want to calculate the factorial:");
        int numberForFactorial = readAndValidateInteger(scanner);
        System.out.println("Factorial of " + numberForFactorial + " is " + calculateFactorial(numberForFactorial));

        //print an array without the duplicates
        printDescription("This app reads an array and prints the array without duplicates");
        int[] arrayWithDuplicates = initializeAndReturnArray(scanner);
        System.out.println("The array without duplicates is: " + Arrays.toString(deleteDuplicates(arrayWithDuplicates)));


//        /*reading an 2 dimensional array that is not square it a bit troublesome(ne need to delete the zeros and return the array)
//        and I don't think that this is the intention for this exercise. If it is needed, I will do it
//        A hardcoded array will be given as argument
//        * */

        printDescription("This app takes an array and prints if the array is square");
        int[][] array2Dim = {{1,2,3},{4,5,6},{7,9}};
        if(isSquare(array2Dim)){
            System.out.println("Array is square");
        }
        else{
            System.out.println("Array is not square");
        }

    }

    private static void calculateContinuous(Scanner altScanner) {
        while (true) {
            double firstNumber = getANumberFromKeyboard(altScanner, "Enter first number and press enter: ");
            double secondNumber = getANumberFromKeyboard(altScanner, "Enter second number and press enter: ");

            System.out.println("Enter operator and press enter: ");
            String operator = altScanner.next();
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    if(result==Double.NEGATIVE_INFINITY||result==Double.POSITIVE_INFINITY){
                        System.out.println("The division against 0 is illegal. In Java the result will be equal to INFINITY");
                    }
                    break;
                default:
                    System.out.println("Semnul introdus nu e valid");
                    return; // acest return are scopul de a opri executia pentru a nu mai printa resultatul mai jos in cazul in care operandul introdus nu este corect
            }
            System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is: " + result);

            System.out.println("Do you want to calculate more? Yes/No");
            String answer = altScanner.next();
            if (answer.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public static void printPrimeNumbers(Scanner scanner) {

        System.out.println("Please enter the integer value of the upper bound:");
        //Scanner scanner = new Scanner(System.in);
        int number = readAndValidateInteger(scanner);

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

    public static int[] deleteDuplicates(int[] numbersArray){
        Arrays.sort(numbersArray);
        int finalArrayLength=getNumberOfDistinctElements(numbersArray);
        //System.out.println(finalArrayLength);
        int[] finalArray = new int[finalArrayLength];
        int j = 0;
        for (int i=0; i<numbersArray.length-1; i++)
            if (numbersArray[i] != numbersArray[i+1])
                finalArray[j++] = numbersArray[i];

        finalArray[j] = numbersArray[numbersArray.length-1];

        return finalArray;
    }

    public static int readAndValidateInteger(Scanner scanner){

        int number;

        while(!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("This is not an integer. Please re-enter the integer:");

        }
        number = scanner.nextInt();

        return number;
    }

    public static int[] initializeAndReturnArray(Scanner scanner){

        System.out.println("Enter the number of elements for the array. It has to be an integer higher than 0:");

        int arrayLength = readAndValidateInteger(scanner);
        while(arrayLength<1) {
            System.out.println("The length of the array should be greater than zero. Re-enter the integer:");
            arrayLength = readAndValidateInteger(scanner);
        }

        int[] numbersArray=new int[arrayLength];
        System.out.println("Enter the integer elements of the array pressing ENTER after each number:");

        for(int i=0;i<arrayLength;i++){
            numbersArray[i]=readAndValidateInteger(scanner);
            //System.out.println(numbersArray[i]);
        }

        return numbersArray;
    }

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

    private static int sumOfFirstNumbers(int highestNumber){
        //method recursively returns the sum of the numbers between 0 the value of highestNumber
        if(highestNumber==1)
            return 1;

        return highestNumber + (sumOfFirstNumbers(highestNumber-1));
    }

    private static boolean isSquare(int[][] a) {
        for (int[] ints : a) {
            if (ints.length != a.length) {
                return false;
            }
        }
        return true;
    }

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

    private static boolean checkIfPalindromeWithString(String numberString) {
        String numberStringInvers = "";
        int stringLength = numberString.length();

        for (int i = stringLength - 1; i >= 0; i--) {
            numberStringInvers += numberString.charAt(i);
        }

        return numberString.equals(numberStringInvers);
    }

    private static int calculateMaxDigit(int number) {
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
        return maxDigit;
    }

    private static int calculateFactorial(int number){

        if(number==0||number==1){
            return number;
        }
        return number*calculateFactorial(number-1);
    }

    private static void calculate(Scanner altScanner) {
        double firstNumber = getANumberFromKeyboard(altScanner, "Enter first number and press enter: ");
        double secondNumber = getANumberFromKeyboard(altScanner, "Enter second number and press enter: ");

        System.out.println("Enter operator and press enter: ");
        String operator = altScanner.next();
        double result = 0;


        if(operator.equals("+")){
            result = firstNumber + secondNumber;
        }
        else if(operator.equals("-")){
            result = firstNumber - secondNumber;
        }
        else if(operator.equals("*")){
            result = firstNumber * secondNumber;
        }
        else if(operator.equals("/")){
            result = firstNumber / secondNumber;
            if(result==Double.NEGATIVE_INFINITY||result==Double.POSITIVE_INFINITY){
                System.out.println("The division against 0 is illegal. In Java the result will be equal to INFINITY");
            }
        }
        else{
            System.out.println("Semnul introdus nu e valid");
        }
        System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is: " + result);
    }

    private static int getANumberFromKeyboard(Scanner altScanner, String mesaj) {
        System.out.println(mesaj);
        return altScanner.nextInt();
    }


    private static void printDescription(String mesaj){
        System.out.println("*************************************************************************************");
        System.out.println(mesaj);
        System.out.println("*************************************************************************************");

    }

}

