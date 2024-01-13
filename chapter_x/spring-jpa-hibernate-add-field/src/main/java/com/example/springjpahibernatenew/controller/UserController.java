package com.example.springjpahibernatenew.controller;

import com.example.springjpahibernatenew.entity.UserEntity;
import com.example.springjpahibernatenew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity entity){
        return userService.save(entity);
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable long userId){
        return userService.get(userId);
    }
}
