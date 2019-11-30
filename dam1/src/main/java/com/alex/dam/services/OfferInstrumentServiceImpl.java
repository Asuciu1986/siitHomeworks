package com.alex.dam.services;


import com.alex.dam.model.Offer;
import com.alex.dam.model.OfferInstrument;
import com.alex.dam.repositories.OfferInstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferInstrumentServiceImpl implements OfferInstrumentService {

    private final OfferInstrumentRepository offerInstrumentRepository;

    public OfferInstrumentServiceImpl(OfferInstrumentRepository offerInstrumentRepository) {
        this.offerInstrumentRepository = offerInstrumentRepository;
    }


    @Override
    public List<OfferInstrument> findByOffer(Offer offer) {
        List<OfferInstrument> instruments = new ArrayList<>();
        offerInstrumentRepository.findByOffer(offer).forEach(instruments::add);
        return instruments;
    }

    @Override
    public List<OfferInstrument> findAll() {
        List<OfferInstrument> instruments = new ArrayList<>();
        offerInstrumentRepository.findAll().forEach(instruments::add);
        return instruments;
    }

    @Override
    public OfferInstrument findById(Long aLong) {
        return offerInstrumentRepository.findById(aLong).orElse(null);
    }

    @Override
    public OfferInstrument save(OfferInstrument object) {
        return offerInstrumentRepository.save(object);
    }

    @Override
    public void delete(OfferInstrument object) {
        offerInstrumentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        offerInstrumentRepository.deleteById(aLong);
    }
}
