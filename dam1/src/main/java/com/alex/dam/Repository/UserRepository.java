package com.alex.dam.Repository;

import com.alex.dam.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
