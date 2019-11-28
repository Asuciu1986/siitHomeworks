package com.alex.dam.repositories;

import com.alex.dam.model.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Optional;

public interface SessionRepository extends CrudRepository<Session,Long> {
    Optional<Session> findByDeliveryDate(Date date);
}
