package com.example.springjpahibernate.entity;

import com.example.springjpahibernate.constant.DBSchemaConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
