package com.alex.dam.repositories;

import com.alex.dam.model.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipantRepository extends CrudRepository <Participant,Long> {

    Participant findByName(String name);

}
