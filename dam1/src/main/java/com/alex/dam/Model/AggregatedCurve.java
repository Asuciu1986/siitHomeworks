package com.alex.dam.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode(exclude = "session")
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AggregatedCurve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Session session;

    private Integer instrument;

    private String curveType;

}
