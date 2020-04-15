package quiz.geometry;


public class MainGeometry {

    public static void main(String[] args) throws CustomException {


        AggregatedShapes aggregatedShapes = new AggregatedShapes();
        Shape patrat = new Square(5);
        Shape rectangle = new Rectangle(3, 4);
        Shape patra2 = new Square(3);

        aggregatedShapes.addShape(patrat);
        aggregatedShapes.addShape(rectangle);
        aggregatedShapes.addShape(patra2);

        aggregatedShapes.calculateData();
        System.out.println(aggregatedShapes.getTotalPerimeter());
        System.out.println(aggregatedShapes.getTotalSurface());

    }
}
