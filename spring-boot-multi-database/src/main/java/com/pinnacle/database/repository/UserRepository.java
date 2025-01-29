package com.pinnacle.database.repository;

import com.pinnacle.database.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // MongoRepository already includes common methods like save(), findAll(), etc.
}
