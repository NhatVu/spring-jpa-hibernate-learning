package org.example.controller;

import org.example.entity.StudentEntity;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity entity){
        StudentEntity res = studentRepository.save(entity);
        return res;
    }

    @GetMapping
    public List<StudentEntity> getStudents(){
        List<StudentEntity> res = studentRepository.findAll();
        return res;
    }
}
