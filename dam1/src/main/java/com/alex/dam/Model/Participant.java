package com.alex.dam.Model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Participant extends Company {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PRE pre;

    public PRE getPre() {
        return pre;
    }

    public void setPre(PRE pre) {
        this.pre = pre;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participant")
    private List<User> users;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Participant(String name, String registrationNumber, Status companyStatus, PRE pre,Address address){
        //override constructor base class
        super(name,registrationNumber,companyStatus);
        this.pre=pre;
        this.address=address;

    }
}
