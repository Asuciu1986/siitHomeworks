package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"participant","pre"})
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Participant participant;

    @OneToOne
    private PRE pre;

    private String street;
    private Integer streetNumber;
    private String city;
    private String country;
    private String phoneNumber;
    private String zipCode;
    private String email;

    //constructors
    public Address(String street, Integer streetNumber, String city, String country, String phoneNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
}
