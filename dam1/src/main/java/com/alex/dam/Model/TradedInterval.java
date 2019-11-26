package com.alex.dam.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.util.Objects;
import javax.persistence.Id;

@Entity
public class TradedInterval {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="id")
    @MapsId
    private OfferInstrument offerInstrument;

    private float acceptedQuantity;

    public float acceptanceRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OfferInstrument getOfferInstrument() {
        return offerInstrument;
    }

    public void setOfferInstrument(OfferInstrument offerInstrument) {
        this.offerInstrument = offerInstrument;
    }

    public float getAcceptedQuantity() {
        return acceptedQuantity;
    }

    public void setAcceptedQuantity(float acceptedQuantity) {
        this.acceptedQuantity = acceptedQuantity;
    }

    public float getAcceptanceRatio() {
        return acceptanceRatio;
    }

    public void setAcceptanceRatio(float acceptanceRatio) {
        this.acceptanceRatio = acceptanceRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradedInterval that = (TradedInterval) o;
        return Float.compare(that.acceptedQuantity, acceptedQuantity) == 0 &&
                Float.compare(that.acceptanceRatio, acceptanceRatio) == 0 &&
                id.equals(that.id) &&
                offerInstrument.equals(that.offerInstrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offerInstrument, acceptedQuantity, acceptanceRatio);
    }
}
