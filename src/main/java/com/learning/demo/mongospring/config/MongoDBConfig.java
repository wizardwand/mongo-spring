package com.learning.demo.mongospring.config;

import com.learning.demo.mongospring.document.Users;
import com.learning.demo.mongospring.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return strings -> {
            userRepository.save(new Users(1, "testUser", "Development", 4000.0));
            userRepository.save(new Users(2, "Ramesh", "Development", 4000.0));
        };
    }
}
