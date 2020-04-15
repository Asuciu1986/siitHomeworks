package quiz.geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Triangle implements Shape {

    private int latura1;
    private int latura2;
    private int latura3;
    private double perimetru;

    public Triangle(int latura1, int latura2, int latura3) throws CustomException {
        if ((latura1 + latura2 > latura3) && (latura2 + latura3 > latura1) && (latura1 + latura3 > latura2)) {
            this.latura1 = latura1;
            this.latura2 = latura2;
            this.latura3 = latura3;
        } else {
            throw new CustomException("Nu este satisfacuta regula unui ca obiectul sa fie triunghi");
        }
    }

    @Override
    public double calculateSurface() {
        double semiperimetru = ((double) (latura1 + latura2 + latura3)) / 2;
        return Math.sqrt(semiperimetru * (semiperimetru - latura1) * (semiperimetru - latura2) * (semiperimetru - latura3));
    }

    @Override
    public double calculatePerimeter() {
        perimetru = latura1 + latura2 + latura3;
        return perimetru;
    }

}
