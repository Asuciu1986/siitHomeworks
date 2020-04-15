package quiz.geometry;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class SquareTest {

    @Test
    void calculateSurface() {
        Shape shape = new Square(3);
        assertEquals(9d,shape.calculateSurface(),0.000001);
    }

    @Test
    void calculatePerimeter() {
        Shape shape = new Square(5);
        assertEquals(20d,shape.calculatePerimeter(),0.000001);
    }
}