package junit1;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;
        String regex = "(\\d+\\s\\w+\\s?[+]?[-]?\\s?)";

        System.out.println("Output type:");
        String outputType = scanner.next();

        scanner.nextLine();
        System.out.print("Enter the non-empty expression:");
        expression = scanner.nextLine();



        Calculator calculator = new Calculator(expression,outputType, regex);
        double result = calculator.calculate();
        System.out.println(result + " " + outputType);

        scanner.close();
//        List<String[]> list = new ArrayList<>();
//
//
//        String expression = "10 cm + 1 m - 10 mm ";
//        String regex = "(\\d+\\s\\w+\\s[+]?[-]?\\s?)";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(expression);
//
//        if(expression.matches(regex)){
//            System.out.println("yes");
//        }
//        else{
//            System.out.println("No");
//        }
//
//        while (matcher.find()){
//            System.out.println(matcher.group(0));
//            list.add(matcher.group(0).calculate(" "));
//        }
//
//        for (String[] op : list
//             ) {
//            for (String i: op
//                 ) {
//                System.out.println(i);
//
//            }
//
//        }
//        String[] components = calculator.calculate(calculator.getExpression());
//
//        System.out.println(components[0]);
//        for (String component:components
//             ) {
//            System.out.println(component);
//
//        }
    }
}
