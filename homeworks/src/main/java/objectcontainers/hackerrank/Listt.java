package objectcontainers.hackerrank;

import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Listt {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int nrOfOperations = scanner.nextInt();

        for (int i = 0; i < nrOfOperations; i++) {
            String operation = scanner.next();
            if (operation.equals("Insert")) {
                int index = scanner.nextInt();
                int integerToInsert = scanner.nextInt();
                list.add(index,integerToInsert);


            } else {
                int indexToDelete = scanner.nextInt();
                list.remove(indexToDelete);
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
