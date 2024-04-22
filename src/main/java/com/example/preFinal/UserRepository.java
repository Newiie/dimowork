package com.example.preFinal.repository;

import com.example.preFinal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

    User findByFirstnameAndLastname(String firstname, String lastname);
}
