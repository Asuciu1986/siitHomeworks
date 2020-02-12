package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Setter
@Getter
public class StudentRepositoryImpl implements StudentRepository, Comparator<Student> {

    private Set<Student> students = new HashSet<>();

    @Override
    public void addStudent(String firstName, String lastName, LocalDate birthDate, String gender,
                           String id) throws CustomBirthDateException,
            CustomEmptyNameException,
            CustomInvalidGenderException {

        if (firstName.equals("") || lastName.equals("")) {
            throw new CustomEmptyNameException("Exception: Student with empty first or last name");
        }

        if (birthDate.getYear() < 1900 || birthDate.getYear() > LocalDate.now().getYear()-18) {
            throw new CustomBirthDateException("Birthdate Exception: Invalid year of birth date");
        }

        if ((!gender.toUpperCase().equals("M")) && !gender.toUpperCase().equals("F")) {
            throw new CustomInvalidGenderException("Gender Exception: The gender does not exist");
        }

        students.add(new Student(id, gender, firstName, lastName, birthDate));
        System.out.println("Student created");
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {

        boolean inserted = false;
        if (id.isEmpty()) {
            throw new Exception("Exception: id is empty");
        } else {
            Optional<Student> stud = students
                    .stream()
                    .filter(student -> student.getId().equals(id))
                    .findFirst();

            if (stud.isPresent()) {
                students.remove(stud);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public Set<Student> listStudentsByAge(Integer age) throws Exception {
        Set<Student> studentsAge = new HashSet<>();
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Exception: You entered null value or < 0");
        }

        for (Student student : students) {
            int ani = Period.between(student.getBirthDate(), LocalDate.now()).getYears();

            if ((Period.between(student.getBirthDate(), LocalDate.now()).getYears() == age)) {
                studentsAge.add(student);
            }
        }

        return studentsAge;

    }

    @Override
    public TreeSet<Student> listStudentsByLastName() {

        TreeSet<Student> studentsByName = new TreeSet<>((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        studentsByName.addAll(students);

        return studentsByName;
    }

    @Override
    public Set<Student> listStudentByBirthDate(LocalDate birthDate) {
        return null;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
