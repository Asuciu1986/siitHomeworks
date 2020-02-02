package objectcontainers.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashSett {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> names = new HashSet<>();

        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        for(int i=0;i<pair_left.length;i++) {
            names.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(names.size());
        }

    }

}
