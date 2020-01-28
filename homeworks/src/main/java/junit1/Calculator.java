package junit1;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class Calculator {

    public final static String[] formats = {"mm", "cm", "dm", "m", "km"};
    private String expression = "10 cm + 1 m - 10 mm + 10 mm";
    private List<String[]> list = new ArrayList<>();
    private String outputType;

    public Calculator(String expression, String outputType) {
        this.expression = expression;
        this.outputType = outputType;
    }

    public static String[] getFormats() {
        return formats;
    }

    public int conversionToUpperMeasure(int result, String outputType) {
        switch (outputType) {
            case "cm":
                result *= 10;
                break;

            case "dm":
                result *= 100;
                break;

            case "m":
                result *= 1000;
                break;

            case "km":
                result *= 1000000;
                break;

        }

        return result;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public int split(String expression, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        int result = 0;
        while (matcher.find()) {
            list.add(matcher.group(0).split(" "));
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String[] item = (String[]) iterator.next();
            int value = conversionToMm(Integer.parseInt(item[0]), item[1]);
            item[0] = String.valueOf(value);
        }

        int size = 0;
        if (list.size() == 1) {
            result = Integer.parseInt(list.get(0)[0]);
        } else if (list.size() == 2) {
            if (list.get(size)[2].equals("+")) {
                result += add(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size + 1)[0]));
            } else {
                result += substract(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size + 1)[0]));
            }
        } else {

            result = add(Integer.parseInt(list.get(size)[0]), Integer.parseInt(list.get(size + 1)[0]));
            while (++size < list.size() - 1) {
                if (list.get(size)[2].equals("+")) {
                    result = add(result, Integer.parseInt(list.get(size + 1)[0]));
                } else {
                    result = substract(result, Integer.parseInt(list.get(size + 1)[0]));
                }
            }

        }
        return result;
    }

    public int conversionToMm(int value, String format) {
        int converted;
        switch (format) {
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

    public int add(int a, int b) {

        return a + b;
    }

    public int substract(int a, int b) {

        return a - b;
    }
}


