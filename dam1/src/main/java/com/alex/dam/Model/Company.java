package com.alex.dam.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    public Status getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Status companyStatus) {
        this.companyStatus = companyStatus;
    }

    //@NotNull
//    @OneToOne(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "addressID", referencedColumnName = "id")
//    @JoinColumn(unique = true)
//    private Address address;

    @NotNull
    @JoinColumn(unique = true)
    private String registrationNumber;


    @NotNull
    @Enumerated(EnumType.STRING)
    private Status companyStatus;

    Company() {
    }

    Company(String name, String registrationNumber, Status companyStatus){
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.companyStatus = companyStatus;

    }
}
