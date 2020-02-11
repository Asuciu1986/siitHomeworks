package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
public class StudentRepositoryImpl implements StudentRepository {

    private Set<Student> students = new HashSet<>();

    @Override
    public void addStudent(String firstName, String lastName, LocalDate birthDate, String gender,
                           String id) throws CustomBirthDateException,
            CustomEmptyNameException,
            CustomInvalidGenderException {

        if(firstName.equals("")||lastName.equals("")){
            throw new CustomEmptyNameException("Exception: Student with empty first or last name");
        }

        if(birthDate.getYear()<1900||birthDate.getYear()>2018){
            throw new CustomBirthDateException("Birthdate Exception: Invalid year of birth date");
        }

        if((!gender.toUpperCase().equals("M"))&&!gender.toUpperCase().equals("F")){
            throw new CustomInvalidGenderException("Gender Exception: The gender does not exist");
        }

        students.add(new Student(id, gender,firstName, lastName, birthDate));
        System.out.println("Student created");
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {

        boolean inserted = false;
        if(id.isEmpty()){
            throw new Exception("Exception: id is empty");
        }
        else{
            Optional<Student> stud = students
                    .stream()
                    .filter(student -> student.getId().equals(id))
                    .findFirst();

            if(stud.isPresent()){
                students.remove(stud);
                return true;
            }
            else{
                return false;
            }

        }


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
