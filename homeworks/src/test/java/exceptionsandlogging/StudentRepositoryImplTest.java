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
        students.addStudent("Alexandru", "Suciu", LocalDate.of(1886, 8, 6), "m", "1860806460034");
    }

    @Test(expected = CustomBirthDateException.class)
    public void addStudent1() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru", "Suciu", LocalDate.of(2015, 8, 6), "m", "1860806460034");
    }

    @Test(expected = CustomInvalidGenderException.class)
    public void addStudent2() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru", "Suciu", LocalDate.of(1996, 8, 6), "unknown", "1860806460034");
    }

    @Test(expected = CustomEmptyNameException.class)
    public void addStudent3() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("", "Suciu", LocalDate.of(1996, 8, 6), "M", "1860806460034");
    }

    @Test(expected = CustomEmptyNameException.class)
    public void addStudent4() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        students.addStudent("Alexandru", "", LocalDate.of(1996, 8, 6), "M", "1860806460034");
    }

    @Test
    public void addStudent5() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {
        StudentRepository students = new StudentRepositoryImpl();
        Student student = new Student("1860806460034", "M", "Alexandru","Suciu",LocalDate.of(1996, 8, 6));
        students.addStudent(student.getFirstName(),student.getLastName(),student.getBirthDate(),student.getGender(),student.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteStudent() {
        StudentRepository students = new StudentRepositoryImpl();
        students.deleteStudent("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteStudent1() {
        StudentRepository students = new StudentRepositoryImpl();
        students.deleteStudent("1923211");
    }


    @Test(expected = IllegalArgumentException.class)
    public void listStudentsByAge() throws Exception {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.addStudent("Alexandru","Suciu", LocalDate.of(1986,8,6),"m","1860806460034");
        studentRepository.addStudent("Dan","Escu", LocalDate.of(1986,8,6),"m","1860306460034");
        studentRepository.addStudent("Vasile","Ionescu", LocalDate.of(1986,8,6),"m","1869806460034");

        studentRepository.listStudentsByAge(-18);
    }

    @Test(expected = IllegalArgumentException.class)
    public void listStudentsByAge2() throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        studentRepository.addStudent("Alexandru","Suciu", LocalDate.of(1986,8,6),"m","1860806460034");
        studentRepository.addStudent("Dan","Escu", LocalDate.of(1986,8,6),"m","1860306460034");
        studentRepository.addStudent("Vasile","Ionescu", LocalDate.of(1986,8,6),"m","1869806460034");

        studentRepository.listStudentsByAge(null);
    }

}

