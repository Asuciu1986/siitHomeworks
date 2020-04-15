package quiz.geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Square implements Shape {

    int latura;

    @Override
    public double calculateSurface() {
        return latura * latura;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * latura;
    }
}
