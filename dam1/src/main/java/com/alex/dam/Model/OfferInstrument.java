package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "offer")
@Builder
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

    @Digits(integer=5,fraction = 1)
    private Float quantity=0f;

    @Digits(integer=5,fraction = 1)
    private Float price=0f;

    public OfferInstrument(Offer offer, Integer instrument, Float quantity, Float price) {
        this.offer = offer;
        this.instrument = instrument;
        this.quantity = quantity;
        this.price = price;
    }


    public OfferInstrument(Offer offer, Integer instrument) {
        this.offer =offer;
        this.instrument=instrument;
    }
}
