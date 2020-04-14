package junit1;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class Calculator {

    private String expression;
    private final static String[] formats = {"mm", "cm", "dm", "m","km"};
    private String outputType;
    private String regex;
    private List<String[]> list = new ArrayList<>();


    public Calculator(String expression, String outputType, String regex) {
        this.expression = expression;
        this.outputType = outputType;
        this.regex = regex;
    }

    public int conversionToMm(int value, String format){
        int converted;
        switch (format){
            case "cm":
                converted = value * 10;
                break;

            case "dm":
                converted = value * 100;
                break;

            case "m":
                converted = value * 1000;
                break;

            case "km":
                converted = value * 1000000;
                break;

            default:
                converted = value;
        }

        return converted;
    }

    public int add(int a, int b){

        return a + b;
    }

    public int substract(int a, int b){

        return a-b;
    }

    public double conversionToUpperMeasure(double result, String outputType){
        switch (outputType){
            case "cm":
                result /= 10;
                break;

            case "dm":
                result /= 100;
                break;

            case "m":
                result /= 1000;
                break;

            case "km":
                result /= 1000000;
                break;

        }

        return result;
    }

    public double calculate(){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        int result = 0;
        int size = 0;

        while(matcher.find()){
            list.add(matcher.group(0).split(" "));
        }

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            String[] item = (String[]) iterator.next();
            int value = conversionToMm(Integer.parseInt(item[0]),item[1]);
            item[0] = String.valueOf(value);
        }


        if(list.size()==1){
            result = Integer.parseInt(list.get(0)[0]);
        }

        else if(list.size()==2){
            if(list.get(size)[2].equals("+")){
                result += add(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size+1)[0]));
            }
            else{
                result += substract(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size+1)[0]));
            }
        }

        else{

            result = add(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size+1)[0]));
            while(++size < list.size()-1){
                if(list.get(size)[2].equals("+")){
                    result = add(result, Integer.parseInt(list.get(size+1)[0]));
                }
                else{
                    result = substract(result, Integer.parseInt(list.get(size+1)[0]));
                }
            }

        }

        return conversionToUpperMeasure(result,outputType);

    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public static String[] getFormats() {
        return formats;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }
}


