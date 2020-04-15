package quiz.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class AggregatedShapesTest {

    @Test
    void addShape() throws CustomException {
        AggregatedShapes aggregatedShapes = new AggregatedShapes();
        Shape shape1 = new Rectangle(2,3);
        Shape shape2 = new Triangle(3,4,5);
        Shape shape3 = new Square(2);
        Shape shape4 = new Circle(2);
        aggregatedShapes.addShape(shape1);
        aggregatedShapes.addShape(shape2);
        aggregatedShapes.addShape(shape3);
        aggregatedShapes.addShape(shape4);
        assertEquals(4,aggregatedShapes.getObjects().size());
    }

    @Test
    void addShape1() throws CustomException {
        AggregatedShapes aggregatedShapes = new AggregatedShapes();
        Shape shape1 = new Rectangle(2,3);
        Shape shape2 = new Rectangle(3,4);
        aggregatedShapes.addShape(shape1);

        Assertions.assertThrows(CustomException.class, () -> {aggregatedShapes.addShape(shape2);});
    }

    @Test
    void calculateData() throws CustomException {
        AggregatedShapes aggregatedShapes = new AggregatedShapes();
        Shape shape1 = new Rectangle(2,3);
        Shape shape2 = new Triangle(3,4,5);
        Shape shape3 = new Square(2);
        Shape shape4 = new Circle(2);
        aggregatedShapes.addShape(shape1);
        aggregatedShapes.addShape(shape2);
        aggregatedShapes.addShape(shape3);
        aggregatedShapes.addShape(shape4);

        aggregatedShapes.calculateData();
        assertEquals((30 + (4*Math.PI)),aggregatedShapes.getTotalPerimeter(),0.001);
        assertEquals((16 + (4*Math.PI)),aggregatedShapes.getTotalSurface(),0.001);
    }
}