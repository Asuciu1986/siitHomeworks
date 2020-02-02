package objectcontainers.HashMap;

import java.util.Objects;

public class Address {

    private String country;
    private String city;
    private String streetname;
    private Integer streetNumber;

    public Address() {
    }

    public Address(String country, String city, String streetname, Integer streetNumber) {
        this.country = country;
        this.city = city;
        this.streetname = streetname;
        this.streetNumber = streetNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return country.equals(address.country) &&
                city.equals(address.city) &&
                streetname.equals(address.streetname) &&
                streetNumber.equals(address.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, streetname, streetNumber);
    }
}
