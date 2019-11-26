package intro_to_java;

public class SquareArray {

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {1, 2},};
        System.out.println(isSquare(a));
    }

    private static boolean isSquare(int[][] a) {
        for (int[] ints : a) {
            if (ints.length != a.length) {
                return false;
            }
        }
        return true;
    }
}