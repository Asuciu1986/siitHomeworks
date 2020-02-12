package exceptionsandlogging;


import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface StudentRepository {

    void addStudent(String firstName, String lastName, LocalDate birthDate, String gender, String id) throws CustomBirthDateException, CustomEmptyNameException, CustomInvalidGenderException;

    boolean deleteStudent(String id) throws Exception;

    Set<Student> listStudentsByAge(Integer age) throws Exception;

    TreeSet<Student> listStudentsByLastName();

    Set<Student> listStudentByBirthDate(LocalDate birthDate);

}
