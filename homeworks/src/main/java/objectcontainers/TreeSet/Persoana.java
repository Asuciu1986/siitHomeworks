package objectcontainers.TreeSet;

import objectcontainers.HashMap.Hobby;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Persoana {

    private String name;
    private Integer age;
    private String gender;
    private List<Hobby> hobbies= new ArrayList<>();

    public Persoana() {
    }

    public Persoana(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Persoana(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return name.equals(persoana.name) &&
                age.equals(persoana.age) &&
                gender.equals(persoana.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
