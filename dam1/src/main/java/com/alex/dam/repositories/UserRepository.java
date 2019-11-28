package com.alex.dam.repositories;

import com.alex.dam.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
