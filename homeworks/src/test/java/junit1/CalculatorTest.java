package junit1;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RunWith(JUnitPlatform.class)
public class CalculatorTest {

    private Calculator calculator= new Calculator("","","(\\d+\\s\\w+\\s?[+]?[-]?\\s?)");
    private Map<String,Long> testTime = new HashMap<>();

    @Test
    public void conversionToMm() {

        long before = System.currentTimeMillis();

        double converted = calculator.conversionToMm(9700, "mm" );
        assertEquals(9700,converted,0.0);

        testTime.put("conversionToMm", System.currentTimeMillis()-before);

    }

    @Test
    public void conversionToMm1() {

        long before = System.currentTimeMillis();

        double converted = calculator.conversionToMm(9700, "m" );
        assertEquals(9700000,converted, 0.0);

        testTime.put("conversionToMm1", System.currentTimeMillis()-before);
    }

    @Test
    public void conversionToMm2() {

        long before = System.currentTimeMillis();

        double converted = calculator.conversionToMm(9700, "dm" );
        assertEquals(970000,converted, 0.0);

        testTime.put("conversionToMm2", System.currentTimeMillis()-before);
    }

    @Test
    public void conversionToMm3() {

        long before = System.currentTimeMillis();

        double converted = calculator.conversionToMm(970, "km" );
        assertEquals(970000000,converted, 0.0);

        testTime.put("conversionToMm3", System.currentTimeMillis()-before);
    }

    @Test
    public void conversionToMm4() {

        double converted = calculator.conversionToMm(9700, "m" );
        assertEquals(9700000,converted,0.0);
    }


    @Test
    public void add() {

        int added = calculator.add(-3,-2);
        assertEquals(-5,added);
    }

    @Test
    public void substract() {

        int substracted = calculator.substract(3,-7);
        assertEquals(10,substracted);
    }

    @Test
    public void conversionToUpperMeasure() {

        double converted = calculator.conversionToUpperMeasure(970000000,"km");
        assertEquals(970,converted, 0.00);
    }

    @Test
    public void conversionToUpperMeasure1() {

        double converted = calculator.conversionToUpperMeasure(970000,"m");
        assertEquals(970,converted, 0.00);
    }

    @Test
    public void conversionToUpperMeasure2() {

        double converted = calculator.conversionToUpperMeasure(970000,"dm");
        assertEquals(9700,converted, 0.00);
    }

    //Todo parameterizedTest... refactor calculate to receive parameters

    @Test
    public void calculate() {

        long before = System.currentTimeMillis();

        calculator.setExpression("1 km + 1 m + 1 dm + 1 cm + 1 mm");
        calculator.setOutputType("mm");
        double result = calculator.calculate();
        assertEquals(1001111,result,0.0);

        testTime.put("calculate", System.currentTimeMillis()-before);
    }

    @Test
    public void calculate2(){

        long before = System.currentTimeMillis();

        calculator.setExpression("1 km + 1 m + 1 dm + 1 cm + 1 mm");
        calculator.setOutputType("m");
        double result = calculator.calculate();
        assertEquals(1001.111,result,0.0);

        testTime.put("calculate2", System.currentTimeMillis()-before);
    }

    @Test
    public void calculate3(){

        long before = System.currentTimeMillis();

        calculator.setExpression("1 km + 1 m + 1 dm + 1 cm + 1 mm");
        calculator.setOutputType("cm");
        double result = calculator.calculate();
        assertEquals(100111.1,result,0.0);

        testTime.put("calculate3", System.currentTimeMillis()-before);
    }

    @Test
    public void calculate5(){
        calculator.setExpression("10000 cm + 10 dm + 1 km ");
        calculator.setOutputType("dm");
        double result = calculator.calculate();
        assertEquals(11010,result,0.0);
    }

    @Test
    public void calculate4(){
        calculator.setExpression("1 km + 1 m + 1 dm + 1 cm + 1 mm");
        calculator.setOutputType("km");
        double result = calculator.calculate();
        assertEquals(1.001111,result,0.0);
    }

    @Test
    public void calculate6(){
        calculator.setExpression("1 m + 1 dm ");
        calculator.setOutputType("mm");
        double result = calculator.calculate();
        assertEquals(1100,result,0.0);
    }

    @Test
    public void calculate7(){
        calculator.setExpression("1 km ");
        calculator.setOutputType("m");
        double result = calculator.calculate();
        assertEquals(1000,result,0.0);
    }

    @Test
    public void calculate8(){
        calculator.setExpression("1000 m + 10000 dm ");
        calculator.setOutputType("km");
        double result = calculator.calculate();
        assertEquals(2,result,0.0);
    }

    @Test
    public void calculate9(){
        calculator.setExpression("1 km ");
        calculator.setOutputType("m");
        double result = calculator.calculate();
        assertEquals(1000,result,0.0);
    }

    @Test
    public void calculate10(){
        calculator.setExpression("0 m + 1 km ");
        calculator.setOutputType("km");
        double result = calculator.calculate();
        assertEquals(1,result,0.0);
    }

    @Test
    public void calculate11(){
        calculator.setExpression("0 m ");
        calculator.setOutputType("km");
        double result = calculator.calculate();
        assertEquals(0,result,0.0);
    }

    /*Todo nu am inteleg ce trebuie sa fac cu structura si unde trebuie sa fie
       structura...
     */

    @Test
    public void printTime(){

        for (Map.Entry<String, Long> entry:testTime.entrySet()
             ) {
            System.out.println("Test " + entry.getKey() + " took " + entry.getValue() +
                    " sec.");
        }
    }




}