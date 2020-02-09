package exceptionsandlogging;


import java.time.LocalDate;

public class Student {

    private long Id;

    private Enum<Gen> gen;

    private String firstName;

    private String lastName;

    public Student() {
    }

    public long getId() {
        return Id;
    }

    public void setId (long id) {
        Id = id;
    }

    public Enum<Gen> getGen() {
        return gen;
    }

    public void setGen(Enum<Gen> gen) {
        this.gen = gen;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    private LocalDate birthDate;




}
