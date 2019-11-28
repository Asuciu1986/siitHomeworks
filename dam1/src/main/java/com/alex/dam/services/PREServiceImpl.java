package com.alex.dam.services;

import com.alex.dam.model.PRE;
import com.alex.dam.repositories.PRERepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PREServiceImpl implements PREService {

    private final PRERepository preRepository;

    public PREServiceImpl(PRERepository preRepository) {
        this.preRepository = preRepository;
    }


    @Override
    public PRE findByName(String name) {
        return preRepository.findByName(name);
    }

    @Override
    public List<PRE> findAll() {
        List<PRE> pres = new ArrayList<>();
        preRepository.findAll().forEach(pres::add);
        return pres;
    }

    @Override
    public PRE findById(Long aLong){
        return preRepository.findById(aLong).orElse(null);
    }

    @Override
    public PRE save(PRE object) {
        return preRepository.save(object);
    }

    @Override
    public void delete(PRE object) {
        preRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        preRepository.deleteById(aLong);
    }
}
