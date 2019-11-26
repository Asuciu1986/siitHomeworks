package intro_to_java;

public class ArrayDeleteDuplicates {

    public static void main(String[] args) {
   //using ArrayDeleteDuplicatesWithoutSort
        ArrayDeleteDuplicatesWithoutSort arrayUnsorted = new ArrayDeleteDuplicatesWithoutSort();
        arrayUnsorted.finalArray = arrayUnsorted.deleteDuplicates(arrayUnsorted.initialArray);
        System.out.println((arrayUnsorted));


        //using ArrayDeleteDuplicatesWithSort

       /* ArrayDeleteDuplicatesWithSort arraySorted = new ArrayDeleteDuplicatesWithSort();
        arraySorted.finalArray = arraySorted.deleteDuplicates(arraySorted.initialArray);
        System.out.println(arraySorted);*/


    }






}
