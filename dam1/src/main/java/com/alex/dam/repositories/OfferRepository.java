package com.alex.dam.repositories;

import com.alex.dam.model.Offer;
import com.alex.dam.model.OrderType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer,Long> {
    List<Offer> findAllByOrderType(OrderType orderType);
}
