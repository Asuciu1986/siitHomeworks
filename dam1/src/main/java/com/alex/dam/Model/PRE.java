package com.alex.dam.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PRE extends Company {

    @NotNull
    @Column(unique = true)
    private String codPre;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "pre", cascade = CascadeType.ALL)
    private List<Participant> participants = new ArrayList<>();

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PRE(){
        super();
    }

    public PRE(String name, String registrationNumber, Status companyStatus, String codPre, Address address) {
        //override constructor base class
        super(name,registrationNumber,companyStatus);
        this.codPre=codPre;
        this.address=address;
    }

    public String getCodPre() {
        return codPre;
    }

    public void setCodPre(String codPre) {
        this.codPre = codPre;
    }

}
