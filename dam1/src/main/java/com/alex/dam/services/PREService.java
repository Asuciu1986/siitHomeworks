package com.alex.dam.services;

import com.alex.dam.model.PRE;

import java.util.List;

public interface PREService extends CrudService<PRE, Long> {

    PRE findByName(String name);

}
