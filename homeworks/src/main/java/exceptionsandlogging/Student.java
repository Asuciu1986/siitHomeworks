package exceptionsandlogging;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {

    private final static String[] genders = {"M","F"};

    private long Id;

    private String gender;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

}
