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
    public Participant(Long id, String name, String registrationNumber, Status companyStatus,
                       PRE pre, Address address, List<User> users){
        super(id, name, registrationNumber, companyStatus);
        this.pre = pre;
        this.address = address;

        if(users!=null){
            this.users=users;
        }
    }


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PRE pre;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participant")
    private List<User> users;



}
