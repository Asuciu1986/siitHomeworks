package objectcontainers.hackerrank;

import java.util.List;
import java.util.Scanner;

public class ArrayList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<int[]> listArrays = new java.util.ArrayList<>();

        int n = scanner.nextInt();

        for(int i=0;i<n;i++){
            int m = scanner.nextInt();
            int[] elementsOnLine = new int[m];

            for (int j=0;j<m;j++){
                elementsOnLine[j]=scanner.nextInt();
            }
            listArrays.add(elementsOnLine);
        }

        int nrOptionsToOutput = scanner.nextInt();

        for(int i=0;i<nrOptionsToOutput;i++){
            int line=scanner.nextInt()-1;
            int column=scanner.nextInt()-1;

            try {
                System.out.println(listArrays.get(line)[column]);
            }

            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("ERROR!");
            }
        }
    }
}
