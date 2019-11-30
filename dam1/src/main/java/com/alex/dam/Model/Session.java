package com.alex.dam.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date tradingDate;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarketPrice> marketPrices= new ArrayList<>();

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AggregatedCurve> aggregatedCurves = new ArrayList<>();

    public Session(Date tradingDate, Date deliveryDate) {
        this.tradingDate = tradingDate;
        this.deliveryDate=deliveryDate;
    }
}



