package com.alex.dam.services;

import com.alex.dam.model.Address;
import com.alex.dam.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().forEach(addresses::add);
        return addresses;
    }

    @Override
    public Address findById(Long aLong) {

        return addressRepository.findById(aLong).orElse(null);
    }

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public void delete(Address object) {
        addressRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        addressRepository.deleteById(aLong);
    }
}
