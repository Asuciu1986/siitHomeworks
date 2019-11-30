package com.alex.dam.repositories;

import com.alex.dam.model.Offer;
import com.alex.dam.model.OfferInstrument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfferInstrumentRepository extends CrudRepository<OfferInstrument,Long> {
    List<OfferInstrument> findByOffer(Offer offer);
}
