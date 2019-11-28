package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Participant extends Company {

    @Builder
    public Participant(Long id, String name, String registrationNumber, Status companyStatus,PRE pre, Address address){
        super(id, name, registrationNumber, companyStatus);
        this.pre = pre;
        this.address = address;
    }
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PRE pre;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participant")
    private List<User> users;

}
