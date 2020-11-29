package com.learning.demo.mongospring.controller;

import com.learning.demo.mongospring.document.Student;
import com.learning.demo.mongospring.document.Users;
import com.learning.demo.mongospring.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping( value = "/add/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody final Student student){
        student.setId(UUID.randomUUID().toString());
        studentRepository.save(student);
        return ;
    }
}
