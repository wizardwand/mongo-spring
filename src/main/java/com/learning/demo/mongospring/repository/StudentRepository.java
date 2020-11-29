package com.learning.demo.mongospring.repository;

import com.learning.demo.mongospring.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
