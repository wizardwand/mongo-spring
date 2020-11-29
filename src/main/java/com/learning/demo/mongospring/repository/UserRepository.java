package com.learning.demo.mongospring.repository;


import com.learning.demo.mongospring.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
