package com.learning.demo.mongospring.controller;

import com.learning.demo.mongospring.document.Users;
import com.learning.demo.mongospring.repository.UserRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping( value = "/add/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody final Users users){
        users.setUpdateTimeStamp(new Date());
        userRepository.save(users);
        return ;
    }

    @PostMapping(value = "/update/user/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody final Users user){
        if(Objects.nonNull(user)){
            Optional<Users> userCurrent = userRepository.findById(user.getId());
            if(userCurrent.isPresent()){
                user.setUpdateTimeStamp(new Date());
                userRepository.save(user);
                return ResponseEntity.status((HttpStatus.OK)).body("User id: "+user.getId()+" Updated!");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not correct, Please give a valid user");
    }
}
