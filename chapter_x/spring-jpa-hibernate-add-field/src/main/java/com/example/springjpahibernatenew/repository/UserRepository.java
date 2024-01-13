package com.example.springjpahibernatenew.repository;

import com.example.springjpahibernatenew.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
