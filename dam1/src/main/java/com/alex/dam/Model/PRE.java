package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PRE extends Company {

    @NotNull
    @Column(unique = true)
    private String codPre;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "pre", cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    @Builder
    public PRE(Long id, String name, String registrationNumber, Status companyStatus, String codPre, Address address) {
        //override constructor base class
        super(id, name,registrationNumber,companyStatus);
        this.codPre=codPre;
        this.address=address;
    }

}
