package com.alex.dam.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Session session;

    private Integer version;

    @OneToOne
    private User user;

    private String orderType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreation;

    @OneToMany(mappedBy = "offer",cascade = CascadeType.ALL)
    private List<OfferInstrument> instruments = new ArrayList<>();

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getDateTimeCreation() {
        return dateTimeCreation;
    }

    public void setDateTimeCreation(Date dateTimeCreation) {
        this.dateTimeCreation = dateTimeCreation;
    }

    public List<OfferInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<OfferInstrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id.equals(offer.id) &&
                session.equals(offer.session) &&
                version.equals(offer.version) &&
                user.equals(offer.user) &&
                orderType.equals(offer.orderType) &&
                dateTimeCreation.equals(offer.dateTimeCreation) &&
                instruments.equals(offer.instruments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, version, user, orderType, dateTimeCreation, instruments);
    }
}
