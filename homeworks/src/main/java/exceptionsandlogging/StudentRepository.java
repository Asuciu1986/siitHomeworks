package exceptionsandlogging;


import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {

    void addStudent(String firstName, String lastName, LocalDate birthDate, String gender, String id);

    boolean deleteStudent(String id);

    List<Student> listStudentsByAge(Integer age);

    List<Student> listStudentsByLastName(String lastName);

    List<Student> listStudentByBirthDate(LocalDate birthDate);

}
