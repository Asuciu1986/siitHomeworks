package quiz.geometry;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class CircleTest {

    @Test
    void calculateSurface() {
        Shape circle = new Circle(5);
        assertEquals(25*Math.PI,circle.calculateSurface(),0.00001);
    }

    @Test
    void calculatePerimeter() {
        Shape circle = new Circle(7);
        assertEquals(14*Math.PI,circle.calculatePerimeter(),0.00001);
    }
}