package org.example.entity;


import lombok.Data;
import org.example.constant.SchemaConstant;

import javax.persistence.*;

@Entity
@Table(name="STUDENT", schema = SchemaConstant.PRIMARY_SCHEMA)
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    @SequenceGenerator(name = "student_id_seq", sequenceName = SchemaConstant.PRIMARY_SCHEMA + ".student_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="STUDENT_NAME", length=50)
    private String name;

    @Transient
    private Integer age;

    // other fields, getters and setters
}
