package junit1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator= new Calculator();

    @Test
    public void conversionToMm() {

        int converted = calculator.conversionToMm(9700, "mm" );
        assertEquals(9700,converted);
    }

    @Test
    public void conversionToMm1() {

        int converted = calculator.conversionToMm(9700, "m" );
        assertEquals(9700000,converted);
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

    @Test
    public void calculateExpression() {

    }

    @Test
    public void getList() {
    }

    @Test
    public void setList() {
    }
}