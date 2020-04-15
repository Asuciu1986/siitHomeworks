package quiz.geometry;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class TriangleTest {

    @Test
    void calculatePerimeter() throws CustomException {
        Shape triangle = new Triangle(3,4,5);
        assertEquals(12d,triangle.calculatePerimeter(),0.00001);
    }

    @Test
    void calculatePerimeter1() throws CustomException {
        Assertions.assertThrows(CustomException.class, () -> {
            new Triangle(2,3,5);
        });
    }

    @Test
    void calculateSurface() throws CustomException {
        Shape triangle = new Triangle(3,4,5);
        System.out.println(triangle.calculateSurface());
        assertEquals(6d,triangle.calculateSurface(),0.00001);
    }

}