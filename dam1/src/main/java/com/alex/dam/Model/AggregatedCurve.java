package com.alex.dam.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AggregatedCurve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Session session;

    private Integer instrument;

    private String curveType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getInstrument() {
        return instrument;
    }

    public void setInstrument(Integer instrument) {
        this.instrument = instrument;
    }

    public String getCurveType() {
        return curveType;
    }

    public void setCurveType(String curveType) {
        this.curveType = curveType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregatedCurve that = (AggregatedCurve) o;
        return id.equals(that.id) &&
                session.equals(that.session) &&
                instrument.equals(that.instrument) &&
                curveType.equals(that.curveType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, instrument, curveType);
    }
}
