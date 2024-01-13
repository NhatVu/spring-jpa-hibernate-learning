package com.example.springjpahibernate.service;

import com.example.springjpahibernate.entity.UserEntity;
import com.example.springjpahibernate.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity entity){
        return userRepository.save(entity);
    }

    public UserEntity get(long userId){
        Optional<UserEntity> entity = userRepository.findById(userId);
        if(entity.isEmpty()){
            return null;
        }
        return entity.get();
    }
}
