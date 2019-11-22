package com.alex.dam.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class MarketPrice {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Session session;

    private Integer instrument;

    private Float marketClearingPrice;

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

    public Float getMarketClearingPrice() {
        return marketClearingPrice;
    }

    public void setMarketClearingPrice(Float marketClearingPrice) {
        this.marketClearingPrice = marketClearingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketPrice that = (MarketPrice) o;
        return id.equals(that.id) &&
                session.equals(that.session) &&
                instrument.equals(that.instrument) &&
                marketClearingPrice.equals(that.marketClearingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, instrument, marketClearingPrice);
    }
}
