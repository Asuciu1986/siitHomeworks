package utils.exceptions;

/*
IOException, FileNotFoundException,
JAXBException,
ParseException,
SQLException,
TimeoutException
ClassNotFoundException
 */

//@Slf4j
public class CheckedExceptions {

    static double circleArea(double radius) throws Exception {
        if (radius < 0) {
            throw new CustomCheckedException("radius should be positive");
        }
        return Math.PI * radius * radius;
    }

    // exemplu prezentare 20
//    public static void main(String[] args) throws Exception {
//
//        double circleAria = circleArea(-2.0);
//        System.out.println("heavy logic");
//        System.out.println("heavy logic");
//        System.out.println("heavy logic");
//        System.out.println("heavy logic");
//        System.out.println("heavy logic");
//
//
//    }

    public static void main(String[] args) {

        try {
            double circleAria = circleArea(-2.0);
            System.out.println("in try");
            System.out.println("in try");
            System.out.println("in try");
        } catch (Exception e) {
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            System.out.println("Invalid   =====");
            e.printStackTrace();
            System.out.println("Invalid radius ++++ " + e.getMessage());

        }


    }
}
