package com.alex.dam.Repository;

import com.alex.dam.Model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface AddressRepository extends CrudRepository<Address,Long> {

}
