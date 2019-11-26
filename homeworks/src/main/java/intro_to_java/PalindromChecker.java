package intro_to_java;

import java.util.Scanner;


public class PalindromChecker {

    public static void main(String[] args) {

        String numberString = getString();

        //uncomment below if we want choose the method checkIfPalindromeWithArray
        //boolean isPalindrome = checkIfPalindromeWithArray(numberString);
        boolean isPalindrome = checkIfPalindromeWithString(numberString);
        if(isPalindrome){
            System.out.println("Number provided is a palindrome");
        }

        else{
            System.out.println("Number provided is not a palindrome");
        }

    }

    public static String getString() {
        System.out.println("Enter the integer that you want to check if it is a palindrome:");
        Scanner scanner = new Scanner(System.in);
        String numberString;

        while(true){
            numberString=scanner.next();
            boolean isInteger=checkIfInteger(numberString);
            if(isInteger){
                break;
            }
        }
        scanner.close();
        return numberString;
    }

    /*
    This boolean method checks if the string received as parameter can be converted to an integer
     */
    private static boolean checkIfInteger(String numberString){
        try{
            if(numberString.charAt(0)=='0'&&numberString.length()>1)
            {
                throw new NumberFormatException();
            }
            int number = Integer.parseInt(numberString);
        }

        catch(NumberFormatException e){
            System.out.println("Number provided is not an integer. Please re-enter:");
            return false;
        }

        return true;
    }

    /*
    This boolean method checks using an array if the number is a palindrome
     */
    private static boolean checkIfPalindromeWithArray(String numberString){
        char[] numberArray = numberString.toCharArray();
        for(int i=0,j=numberArray.length-1;i<(numberArray.length-1)/2 && j>(numberArray.length-1)/2;i++,j--){
            if(numberArray[i]!=numberArray[j]){
                return false;
            }
        }
        return true;
    }

    /*
    This boolean method checks using a string if the number is a palindrome
     */
    private static boolean checkIfPalindromeWithString(String numberString) {
        String numberStringInvers = "";
        int stringLength = numberString.length();

        for (int i = stringLength - 1; i >= 0; i--) {
            numberStringInvers += numberString.charAt(i);
        }

        return numberString.equals(numberStringInvers);
    }

}
