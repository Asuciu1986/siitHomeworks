package com.alex.dam.Model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Participant participant;

    @OneToOne
    private PRE pre;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public PRE getPre() {
        return pre;
    }

    public void setPre(PRE pre) {
        this.pre = pre;
    }

    @NotNull
    private String street;

    @NotNull
    private Integer streetNumber;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String phoneNumber;

    private String zipCode;
    private String email;

    //getters and setters
    public Long getAddressId() {
        return id;
    }

    public void setAddressId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //constructors

    public Address() {
    }

    public Address(String street, Integer streetNumber, String city, String country, String phoneNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
}
