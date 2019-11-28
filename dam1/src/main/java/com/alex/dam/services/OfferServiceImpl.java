package com.alex.dam.services;

import com.alex.dam.model.Offer;
import com.alex.dam.model.OrderType;
import com.alex.dam.repositories.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> findAllByOrderType(OrderType orderType) {
        List<Offer> offers = new ArrayList<>(offerRepository.findAllByOrderType(orderType));
        return offers;
    }

    @Override
    public List<Offer> findAll() {
        List<Offer> offers = new ArrayList<>();
        offerRepository.findAll().forEach(offers::add);
        return offers;
    }

    @Override
    public Offer findById(Long aLong) {
        return offerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Offer save(Offer object) {
        return offerRepository.save(object);
    }

    @Override
    public void delete(Offer object) {
        offerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        offerRepository.deleteById(aLong);
    }
}
