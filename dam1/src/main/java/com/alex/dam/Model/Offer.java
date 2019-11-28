package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
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

    @ManyToOne
    private Session session;

    private Integer version;

    @OneToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreation;

    @OneToMany(mappedBy = "offer",cascade = CascadeType.ALL)
    private List<OfferInstrument> instruments = new ArrayList<>();

}
