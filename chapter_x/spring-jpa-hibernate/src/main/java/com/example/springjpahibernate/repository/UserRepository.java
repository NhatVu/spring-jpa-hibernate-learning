package com.example.springjpahibernate.repository;

import com.example.springjpahibernate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
