package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayStudent {

    public static void main(String[] args) throws Exception {


            StudentRepository studentRepository = new StudentRepositoryImpl();
            studentRepository.addStudent("Alexandru","Suciu", LocalDate.of(1986,8,6),"m","1860806460034");
            studentRepository.addStudent("Dan","Escu", LocalDate.of(1986,8,6),"m","1860306460034");
            studentRepository.addStudent("Vasile","Ionescu", LocalDate.of(1986,8,6),"m","1869806460034");
            studentRepository.addStudent("Doru","Popescu", LocalDate.of(1996,8,6),"m","1860816460034");
            studentRepository.addStudent("dd","Ion", LocalDate.of(1989,8,6),"m","1860806460034");
            studentRepository.listStudentsByAge(null);

        //  System.out.println(studentRepository.deleteStudent(""));

            //studentRepository.listStudentsByAge(33).forEach(System.out::println);

            studentRepository.listStudentsByLastName().forEach(System.out::println);

    }
}
