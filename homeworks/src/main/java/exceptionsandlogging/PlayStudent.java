package exceptionsandlogging;

import exceptionsandlogging.customexceptions.CustomBirthDateException;
import exceptionsandlogging.customexceptions.CustomEmptyNameException;
import exceptionsandlogging.customexceptions.CustomInvalidGenderException;

import java.time.LocalDate;

public class PlayStudent {

    public static void main(String[] args) throws CustomEmptyNameException, CustomInvalidGenderException, CustomBirthDateException {

            StudentRepository studentRepository = new StudentRepositoryImpl();
            studentRepository.addStudent("Alexandru","Suciu", LocalDate.of(1986,8,6),"m","1860806460034");

    }
}
