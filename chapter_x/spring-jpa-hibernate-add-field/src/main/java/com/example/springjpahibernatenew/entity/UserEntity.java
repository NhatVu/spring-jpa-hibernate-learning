package com.example.springjpahibernatenew.entity;

import com.example.springjpahibernatenew.constant.DBSchemaConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = DBSchemaConstant.SCHEMA_DEMO)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    public long userId;
    public String userName;
    private int age;
}
