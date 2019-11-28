package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
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

    private Float quantity;

    private Float price;

}
