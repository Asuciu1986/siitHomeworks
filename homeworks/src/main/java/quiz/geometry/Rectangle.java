package quiz.geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rectangle implements Shape {

    private int lungime;
    private int latime;

    @Override
    public double calculateSurface() {
        return lungime * latime;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (lungime + latime);
    }
}
