package com.alex.dam.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Instrument {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    //todo relationship and think about
    //relatie MtM cu session
    @OneToMany(mappedBy = "instruments", cascade = CascadeType.ALL)
    private List<SessionInstrument> instruments = new ArrayList<>();

    //Constructori

    public Instrument() {
    }

    public Instrument(@NotNull String name, @NotNull String description, List<SessionInstrument> instruments) {
        this.name = name;
        this.description = description;
        this.instruments = instruments;
    }

    //Getters and setters


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<SessionInstrument> instruments) {
        this.instruments = instruments;
    }

    //Hashcode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                instruments.equals(that.instruments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, instruments);
    }


}

