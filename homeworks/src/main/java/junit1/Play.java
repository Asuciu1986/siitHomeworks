package junit1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Play {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("10 cm + 1 m - 10 mm ","mm");

        int result = calculator.split("10 cm + 1 m - 10 mm ","(\\d+\\s\\w+\\s[+]?[-]?\\s?)");
        System.out.println(result);

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
//            list.add(matcher.group(0).split(" "));
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
//        String[] components = calculator.split(calculator.getExpression());
//
//        System.out.println(components[0]);
//        for (String component:components
//             ) {
//            System.out.println(component);
//
//        }
    }
}
