package com.alex.dam.services;

import com.alex.dam.model.Offer;
import com.alex.dam.model.OfferInstrument;

import java.util.List;

public interface OfferInstrumentService extends CrudService<OfferInstrument,Long> {

    List<OfferInstrument> findByOffer(Offer offer);
}
