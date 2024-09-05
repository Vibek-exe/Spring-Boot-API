package com.vivek.springBootApplication.repository;

import com.vivek.springBootApplication.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepository extends MongoRepository<UserEntry, ObjectId> {

    UserEntry findByUserName(String username);
}
