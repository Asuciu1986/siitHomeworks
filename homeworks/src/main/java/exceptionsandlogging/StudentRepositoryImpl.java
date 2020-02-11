package exceptionsandlogging;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryImpl implements StudentRepository{

    private  Set<Student> students = new HashSet<>();

    @Override
    public void addStudent(String firstName, String lastName, LocalDate birthDate, String gender, String id)  {

    }

    @Override
    public boolean deleteStudent(String id) {
        return false;
    }

    @Override
    public List<Student> listStudentsByAge(Integer age) {
        return null;
    }

    @Override
    public List<Student> listStudentsByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Student> listStudentByBirthDate(LocalDate birthDate) {
        return null;
    }
}
