package com.alex.dam.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "participant")
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Offer> offers = new ArrayList<>();

    private String name;
    private String email;
    private String password;

    @ManyToOne
    private Participant participant;

}
