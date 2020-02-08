package objectcontainers.hackerrank;

import java.util.*;


public class Array1DPart2 {


    public static boolean canWin(int leap, int[] game, int i) {
        if (i < 0 || game[i] == 1)
            return false;
        if (i + 1 >= game.length || i + leap >= game.length)
            return true;

        game[i] = 1; //flag

        return canWin(leap, game, i + leap)
                || canWin(leap, game, i + 1)
                || canWin(leap, game, i - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game, 0)) ? "YES" : "NO");
        }
        scan.close();
    }
//    public static boolean canWin(int leap, int[] game) {
//        // Return true if you can win the game; otherwise, return false.
//        int cursor = 0;
//        boolean leaped = false;
//
//        while(cursor<=game.length) {
//            if ((leap + cursor > game.length-1)||(cursor==game.length-1)) {
//                return true;
//            } else if ((game[cursor + leap] == 0)&&(leap>1)) {
//                cursor += leap;
//                leaped = true;
//            } else if (game[cursor + 1] == 0) {
//                cursor++;
//                leaped=false;
//            } else if((cursor-1>=0)&&(game[cursor-1]==0)&&(leaped)){
//                game[cursor] = 1;
//                cursor--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int q = scan.nextInt();
//        while (q-- > 0) {
//            int n = scan.nextInt();
//            int leap = scan.nextInt();
//
//            int[] game = new int[n];
//            for (int i = 0; i < n; i++) {
//                game[i] = scan.nextInt();
//            }
//
//            System.out.println((canWin(leap, game)) ? "YES" : "NO");
//        }
//        scan.close();
//    }
}

