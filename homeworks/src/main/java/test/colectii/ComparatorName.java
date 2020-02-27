package test.colectii;

import java.util.Comparator;

public class ComparatorName implements Comparator<Student> {

    public int compare(Student s1, Student s2){

        if(s1.name.compareTo(s2.name)>0)
            return 1;
        else if(s1.name.equals(s2.name))
            return 0;
        else
            return -1;
    }
}
