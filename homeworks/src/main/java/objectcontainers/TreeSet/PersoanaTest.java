package objectcontainers.TreeSet;

import java.util.*;

public class PersoanaTest {

    public static void main(String[] args) {
        Set<Persoana> persoane = new TreeSet<>(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {

                if (o1.getName().equals(o2.getName())) {
                    if (o1.getAge().equals(o1.getAge())) {
                        return o1.getAge();
                    } else {
                        return o1.getAge()-o2.getAge();
                    }

                } else {
                    return o1.getName().compareTo(o2.getName());
                }

            }
        });


//        Set<Persoana> persoaneNume = new TreeSet<>(new Comparator<Persoana>() {
//            @Override
//            public int compare(Persoana o1, Persoana o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        Set<Persoana> persoane = new TreeSet<>(new Comparator<Persoana>() {
//            @Override
//            public int compare(Persoana o1, Persoana o2) {
//                return o1.getAge()-o2.getAge();
//            }
//
//        });
//
//

        persoane.add(new Persoana("Dana", 30));
        persoane.add(new Persoana("Dana", 31));
        persoane.add(new Persoana("Ana", 30));
        persoane.add(new Persoana("Alex", 33));
        persoane.add(new Persoana("Zoe", 27));

        for (Persoana persoana : persoane
        ) {
            System.out.println("Name:" + persoana.getName() + " Age:" + persoana.getAge());
        }
    }


}
