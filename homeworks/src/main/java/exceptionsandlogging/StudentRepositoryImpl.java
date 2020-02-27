package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Setter
@Getter
public class StudentRepositoryImpl implements StudentRepository {

    private final static Logger LOGGER = Logger.getLogger(StudentRepositoryImpl.class.getName());
    private Set<Student> students = new HashSet<>();

    @Override
    public void addStudent(String firstName, String lastName, LocalDate birthDate, String gender,
                           String id) throws CustomBirthDateException,
            CustomEmptyNameException,
            CustomInvalidGenderException {

        if (firstName.equals("") || lastName.equals("")) {
            LOGGER.log(Level.SEVERE, "First Name = " + firstName + " or last name = " + lastName + " entered is empty");
            throw new CustomEmptyNameException("Exception: Student with empty first or last name");
        }

        if (birthDate.getYear() < 1900 || birthDate.getYear() > LocalDate.now().getYear() - 18) {
            LOGGER.log(Level.SEVERE, "Year of birth " + birthDate.getYear() + " is not between 1900 and current year - 18.");
            throw new CustomBirthDateException("Birthdate Exception: Invalid year of birth date");
        }

        if ((!gender.toUpperCase().equals("M")) && !gender.toUpperCase().equals("F")) {
            LOGGER.log(Level.SEVERE, "Gender " + gender + " is not m,M,f or F, the valid options.");
            throw new CustomInvalidGenderException("Gender Exception: The gender does not exist");
        }

        Student student = new Student(id, gender, firstName, lastName, birthDate);
        students.add(student);
        LOGGER.log(Level.INFO, "Student " + student.toString() + " created.");
        System.out.println("Student created");
    }

    @Override
    public boolean deleteStudent(String id) {

        if (id.isEmpty()) {
            throw new IllegalArgumentException("Exception: id is empty");
        } else {
            Optional<Student> stud = students
                    .stream()
                    .filter(student -> student.getId().equals(id))
                    .findFirst();

            if (stud.isPresent()) {
                students.remove(stud);
                LOGGER.log(Level.INFO, "Student " + stud.toString() + " deleted.");
                return true;
            } else {
                LOGGER.log(Level.SEVERE, "Entered Id  " + id + " does not exist.");
                throw new IllegalArgumentException("Id does not exist");
            }
        }
    }

    @Override
    public Set<Student> listStudentsByAge(Integer age) throws IllegalArgumentException {
        Set<Student> studentsOfAge = new HashSet<>();
        if (age == null || age < 0) {
            LOGGER.log(Level.SEVERE, "Age entered " + age + " is not valid");
            throw new IllegalArgumentException("Exception: You entered null value or < 0");
        }

        for (Student student : students) {
            if ((Period.between(student.getBirthDate(), LocalDate.now()).getYears() == age)) {
                studentsOfAge.add(student);
            }
        }

        return studentsOfAge;

    }

    @Override
    public TreeSet<Student> listStudentsByLastName() {

        TreeSet<Student> studentsByName = new TreeSet<>(Comparator.comparing(Student::getLastName));

        studentsByName.addAll(students);

        return studentsByName;
    }


}
