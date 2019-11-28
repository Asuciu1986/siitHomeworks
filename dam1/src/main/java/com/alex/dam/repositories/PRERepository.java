package com.alex.dam.repositories;

import com.alex.dam.model.PRE;
import com.alex.dam.model.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PRERepository extends CrudRepository<PRE,Long> {

    PRE findByName(String name);
}

