package com.alex.dam.services;

import com.alex.dam.model.Offer;
import com.alex.dam.model.OrderType;

import java.util.List;

public interface OfferService extends CrudService<Offer, Long> {

    List<Offer> findAllByOrderType(OrderType orderType);

}
