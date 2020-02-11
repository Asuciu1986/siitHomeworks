package exceptionsandlogging;


import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {

    void addStudent(String firstName, String lastName, LocalDate birthDate, String gender, String id) throws CustomBirthDateException, CustomEmptyNameException, CustomInvalidGenderException;

    boolean deleteStudent(String id) throws Exception;

    List<Student> listStudentsByAge(Integer age);

    List<Student> listStudentsByLastName(String lastName);

    List<Student> listStudentByBirthDate(LocalDate birthDate);

}
