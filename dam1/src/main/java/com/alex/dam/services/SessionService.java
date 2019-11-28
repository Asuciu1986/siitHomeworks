package com.alex.dam.services;

import com.alex.dam.model.Session;

import java.util.Date;
import java.util.Optional;

public interface SessionService extends CrudService<Session, Long> {

    Session findByDeliveryDate(Date date);

}
