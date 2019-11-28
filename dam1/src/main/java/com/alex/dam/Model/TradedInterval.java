package com.alex.dam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
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

}
