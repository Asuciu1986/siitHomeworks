package test.colectii;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class Play {

    public static void main(String[] args) {


        Trade trade1 = new Trade(1,50.5676f, LocalDateTime.of(2015,6,12,12,23,22));
        Trade trade2 = new Trade(2,100.5676f, LocalDateTime.of(2016,7,12,12,23,22));
        Trade trade3 = new Trade(3,150.5676f, LocalDateTime.of(2017,7,12,12,23,22));
        Trade trade4 = new Trade(4,270.5676f, LocalDateTime.of(2018,7,12,12,23,22));
        Trade trade5 = new Trade(5,250.5676f, LocalDateTime.of(2019,7,12,12,23,22));

        TreeSet<Trade> trades = new TreeSet<>();
        trades.add(trade5);
        trades.add(trade3);
        trades.add(trade2);
        trades.add(trade1);
        trades.add(trade4);


        Set<Trade> trades1 = new HashSet<>();
        trades1.add(trade5);
        trades1.add(trade3);
        trades1.add(trade2);
        trades1.add(trade1);
        trades1.add(trade4);

        trades1.forEach(s -> System.out.println(s.timestamp));



//        Student s1 = new Student("Alex", 33);
//        Student s2 = new Student("Ovidas", 38);
//        Student s3 = new Student("Ionel", 42);
//
//
//
//        Comparator<Student> comparatorNume = new ComparatorName();
//
//        Set<Student> studenti = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.age-o2.age;
//            }
//        });
//
//        studenti.add(s1);
//        studenti.add(s2);
//        studenti.add(s3);
//
//        studenti.forEach(student -> System.out.println(student.name + " " + student.age) );
//
//
//
//
//
////        Set<Integer> integere = new TreeSet<>();
////
//        integere.add(1);
//        integere.add(10);
//        integere.add(20);
//        integere.add(5);
//        integere.add(4);
//        integere.add(4);

//        String[] array = {"Dan", "asdasda"};
////
////        Iterator<Integer> it = integere.iterator();
////
////        while(it.hasNext()){
////            System.out.println(it.next());
////        }
////
////        Map<Integer, List<String>> mapper = new HashMap<>();
////
////        mapper.put(1, Arrays.asList(array));
////        mapper.put(2,Arrays.asList(array));
////        mapper.put(1,Arrays.asList(array));
////        mapper.put(3,Arrays.asList(array));
////
////        System.out.println(mapper.get(3));
////
////        Set set = mapper.entrySet();
////        Iterator itrSet = set.iterator();
////        while(itrSet.hasNext()){
////
////            System.out.println(itrSet.next());
////        }
////
////
////        Iterator iter = set.iterator();
////
////        while(iter.hasNext()){
////            Map.Entry entry = (Map.Entry)iter.next();
////            System.out.println(entry.getKey() + " " + entry.getValue());
////        }
////
////        set.forEach(System.out::println);
//////        List<String> arraylista = new ArrayList<>();
//////        arraylista.add("Ala bala");
//////        arraylista.add("babanel");
//////
//////        // Creating empty priority queue
//////        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//////
//////        // Adding items to the pQueue using add()
//////        pQueue.add(10);
//////        pQueue.add(20);
//////        pQueue.add(15);
//////        pQueue.add(65);
//////        pQueue.add(45);
//////        pQueue.add(35);
//////        pQueue.remove(2)
//////
//////        System.out.println(pQueue.peek());
//////        System.out.println(pQueue.remove());
//////        System.out.println(pQueue.peek());
//////        System.out.println(pQueue.remove());
//////        System.out.println(pQueue.peek());
//////
//////
//////        Queue<String> queue=new PriorityQueue<String>();
//////        queue.add("Amit Sharma");
//////        queue.add("Vijay Raj");
//////        queue.add("JaiShankar");
//////        queue.add("Raj");
//////        queue.remove();
//////        Iterator itr=queue.iterator();
//////        while(itr.hasNext()){
//////            System.out.println(itr.next());
//////        }
//////        //queue.remove();
//////        //queue.poll();
//////
//////
//////        LinkedList<Integer> integers = new LinkedList<>();
//////        integers.add(1);
//////        integers.add(2);
//////        integers.add(1,23);
//////
//////        for (int i: integers
//////             ) {
//////            System.out.println(i);
//////        }
//////
//////
////        List<String> lista2 = new ArrayList<>();
////        lista2.add("rahat");
////        lista2.add("pe bat");
////
////        Collections.sort(lista2, Collections.reverseOrder());
//////
//////        arraylista.addAll(1,lista2);
//////
//////        for (String s: arraylista
//////             ) {
//////            System.out.println(s);
//////        }
//////
//////        arraylista.remove("ciaurel");
//////        arraylista.toArray();
//////        String[] arrayString = new String[arraylista.size()];
//////        arraylista.toArray(arrayString);
//////
//////        for (String s: arrayString
//////             ) {
//////            System.out.println(s);
//////
//////        }
//////
//////        for (String elLista: arraylista
//////             ) {
//////            System.out.println(elLista);
//////        }
//////
//////        boolean coletctiiEgale = arraylista.equals(lista2);
//////        System.out.println(coletctiiEgale);
//////
//////        System.out.println(arraylista.hashCode());
//////
//////        Stream<String> ss = arraylista.stream();
//////
//////        System.out.println(arraylista.get(2));

    }
}
