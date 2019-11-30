package com.alex.dam.model;

import lombok.*;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"session"})
@Builder
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Session session;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    public void setInstrument(Integer index,OfferInstrument offerInstrument) {
        this.instruments.set(index, offerInstrument);
    }

    public void setInstruments(List<OfferInstrument> instruments) {
        this.instruments = instruments;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date date=new Date();

    @OneToMany(mappedBy = "offer",cascade = CascadeType.ALL)
    @Getter
    private List<OfferInstrument> instruments = new ArrayList<>(24);

    public Offer(@NotNull Session session, User user, OrderType orderType) {
        this.session = session;
        this.user = user;
        this.orderType = orderType;
        for(int i=0;i<24;i++){
            instruments.add(new OfferInstrument(this, i + 1));
        }
    }
}
