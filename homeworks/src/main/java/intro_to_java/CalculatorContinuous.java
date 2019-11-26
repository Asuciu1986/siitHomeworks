package intro_to_java;

import java.util.Scanner;


public class CalculatorContinuous {


    public static void main(String[] args) {
        Scanner altScanner = new Scanner(System.in);
        calculate(altScanner);

    }

    private static double getANumberFromKeyboard(Scanner altScanner, String mesaj) {
        System.out.println(mesaj);
        return altScanner.nextDouble();
    }

    private static void calculate(Scanner altScanner) {
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


}

