package org.example.entity;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.constant.SchemaConstant;
import org.example.events.StudentEntityListener;
import javax.persistence.*;


@EntityListeners(StudentEntityListener.class)
@Entity
@Table(name="STUDENT", schema = SchemaConstant.PRIMARY_SCHEMA)
@Data
@Slf4j
@ToString
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

    @PrePersist
    public void prePersist(){
        log.info("call prePersist for Student Entity: " + this);
    }
}
