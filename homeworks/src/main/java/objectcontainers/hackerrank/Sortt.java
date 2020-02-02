package objectcontainers.hackerrank;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double cgpa;

    List<Integer> lista = new ArrayList<>();


    private static Comparator<Student> comp =
            Comparator.comparingDouble(Student::getCgpa).reversed()
                    .thenComparing(Student::getFname)
                    .thenComparingInt(Student::getId);

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        return comp.compare(this,other);
    }

}


public class Sortt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        List<Integer> lista2 = new Vector<>();
        lista2.add(3);




        Stack<String> stack = new Stack<String>();
        stack.push("3");
        stack.push("4");
        String a = stack.peek();
        stack.pop();
        System.out.println(a);

        PriorityQueue<String> prQueue = new PriorityQueue<>();
        prQueue.add("Alex");
        prQueue.add("Puiu");
        prQueue.remove();

        String s1 = "asdsa";
        String s2 = "deded";
        System.out.println(s1.compareTo(s2));


        System.out.println(prQueue.element());

        SortedSet<String> seturi = new TreeSet<>();


        Iterator itr = prQueue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

//        int testCases = Integer.parseInt(in.nextLine());
//
//        List<Student> studentList = Stream.generate(() ->
//                new Student(in.nextInt(),
//                    in.next(),
//                    in.nextDouble())).limit(testCases).sorted().collect(toList());
//
//        for (Student st : studentList) {
//            System.out.println(st.getFname());
//        }
    }
}
