package com.alex.dam.services;

import com.alex.dam.model.Participant;

public interface ParticipantService extends CrudService<Participant, Long> {

    Participant findByName(String name);

}
