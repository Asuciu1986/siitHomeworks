package exceptionsandlogging;

import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Student {

    private final static Set<String> genders = new HashSet<>(Arrays.asList("M","F"));

    private String id;

    private String gender;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

}
