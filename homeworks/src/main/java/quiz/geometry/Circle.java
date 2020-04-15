package quiz.geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Circle implements Shape {

    int raza;

    @Override
    public double calculateSurface() {
        return Math.PI * raza * raza;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * raza;
    }
}
