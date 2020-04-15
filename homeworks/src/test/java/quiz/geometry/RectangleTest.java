package quiz.geometry;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class RectangleTest {

    @Test
    void calculateSurface() {
        Shape shape = new Rectangle(3,4);
        assertEquals(12d,shape.calculateSurface(),0.000001);
    }

    @Test
    void calculatePerimeter() {
        Shape shape = new Rectangle(3,4);
        assertEquals(14d,shape.calculatePerimeter(),0.000001);
    }
}