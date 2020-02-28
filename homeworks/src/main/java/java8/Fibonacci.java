package java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public static int[] fibonacciGeneration(int n){

        //nu stiu cum sa trec de la Integer la int altfel
        //primele 100 de numere nu intra in int. m-am oprit la 10

        return Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(n)
                .mapToInt(i -> i[0])
                .toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(fibonacciGeneration(10)));
    }
}
