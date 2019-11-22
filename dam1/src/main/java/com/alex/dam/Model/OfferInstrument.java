package com.alex.dam.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OfferInstrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Offer offer;

    @OneToOne(mappedBy = "offerInstrument")
    private TradedInterval tradedInterval;

    private Integer instrument;

    private Float quantity;

    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Integer getInstrument() {
        return instrument;
    }

    public void setInstrument(Integer instrument) {
        this.instrument = instrument;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferInstrument that = (OfferInstrument) o;
        return id.equals(that.id) &&
                offer.equals(that.offer) &&
                instrument.equals(that.instrument) &&
                quantity.equals(that.quantity) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offer, instrument, quantity, price);
    }
}
