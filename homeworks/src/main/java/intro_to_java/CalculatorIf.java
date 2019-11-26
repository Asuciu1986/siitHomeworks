package intro_to_java;

import java.util.Scanner;


public class CalculatorIf {


    public static void main(String[] args) {
        Scanner altScanner = new Scanner(System.in);
        calculate(altScanner);

    }

    private static double getANumberFromKeyboard(Scanner altScanner, String mesaj) {
        System.out.println(mesaj);
        return altScanner.nextDouble();
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

/*        if(operator.equals("+")){
            result = firstNumber + secondNumber;
        }
        else {
            if(operator.equals("-")){
                result = firstNumber - secondNumber;
            }
            else {
                if(operator.equals("*")){
                    result = firstNumber * secondNumber;
                }
                else{
                    if(operator.equals("/")){
                        result = firstNumber / secondNumber;
                        if(result==Double.NEGATIVE_INFINITY||result==Double.POSITIVE_INFINITY){
                        System.out.println("The division against 0 is illegal. In Java the result will be equal to INFINITY");
                        }
                    }
                    else{
                        System.out.println("Semnul introdus nu e valid");
                    }
                }
            }
        }*/

        System.out.println("The result of " + firstNumber + " " + operator + " " + secondNumber + " is: " + result);
        }

    }




