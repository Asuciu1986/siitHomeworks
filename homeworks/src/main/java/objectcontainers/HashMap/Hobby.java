package objectcontainers.HashMap;

import java.util.Objects;

public class Hobby {

    private String name;
    private Integer frequency;
    private Address address;

    public Hobby() {
    }

    public Hobby(String name, Integer frequency, Address address) {
        this.name = name;
        this.frequency = frequency;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return name.equals(hobby.name) &&
                frequency.equals(hobby.frequency) &&
                address.equals(hobby.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, frequency, address);
    }
}
