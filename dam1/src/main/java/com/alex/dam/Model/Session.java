package com.alex.dam.Model;


import javax.persistence.*;
import javax.swing.plaf.basic.BasicBorders;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date tradingDate;

    @NotNull
    private Date deliveryDate;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarketPrice> marketPrices= new ArrayList<>();

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AggregatedCurve> aggregatedCurves = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<MarketPrice> getMarketPrices() {
        return marketPrices;
    }

    public void setMarketPrices(List<MarketPrice> marketPrices) {
        this.marketPrices = marketPrices;
    }

    public List<AggregatedCurve> getAggregatedCurves() {
        return aggregatedCurves;
    }

    public void setAggregatedCurves(List<AggregatedCurve> aggregatedCurves) {
        this.aggregatedCurves = aggregatedCurves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id.equals(session.id) &&
                tradingDate.equals(session.tradingDate) &&
                deliveryDate.equals(session.deliveryDate) &&
                Objects.equals(marketPrices, session.marketPrices) &&
                Objects.equals(aggregatedCurves, session.aggregatedCurves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tradingDate, deliveryDate, marketPrices, aggregatedCurves);
    }
}



