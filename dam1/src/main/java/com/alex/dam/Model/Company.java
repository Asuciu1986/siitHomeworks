package com.alex.dam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(unique = true)
    private String registrationNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status companyStatus;

    public boolean isNew(){
        return this.id == null;
    }
}
