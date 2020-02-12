package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {

    @Test(expected = CustomBirthDateException.class)
    public void addStudent() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru","Suciu", LocalDate.of(1886,8,6),"m","1860806460034");
    }

    @Test(expected = CustomBirthDateException.class)
    public void addStudent1() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru","Suciu", LocalDate.of(2015,8,6),"m","1860806460034");
    }

    @Test(expected = CustomInvalidGenderException.class)
    public void addStudent2() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru","Suciu", LocalDate.of(1996,8,6),"unknown","1860806460034");
    }

    @Test(expected = CustomEmptyNameException.class)
    public void addStudent3() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("","Suciu", LocalDate.of(1996,8,6),"M","1860806460034");
    }









    @Test
    public void listStudentsByAge() {
    }

    @Test
    public void listStudentsByLastName() {
    }

    @Test
    public void listStudentByBirthDate() {
    }

    @Test
    public void compare() {
    }
}