package quiz.geometry;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AggregatedShapes {

    private Set<Shape> objects = new HashSet<>();
    private double totalPerimeter;
    private double totalSurface;

    public void addShape(Shape shape) throws CustomException {
        for (Shape object : objects
        ) {
            if (shape.getClass() == object.getClass()) {
                throw new CustomException("You already entered object of type: " + object.getClass());
            }
        }
        objects.add(shape);
    }

    public void calculateData() {
        for (Shape object : objects
        ) {
            totalPerimeter += object.calculatePerimeter();
            totalSurface += object.calculateSurface();
        }
    }
}
