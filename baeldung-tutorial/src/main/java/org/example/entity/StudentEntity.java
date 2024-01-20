package org.example.entity;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.constant.SchemaConstant;
import org.example.entity.events.StudentEntityListener;
import javax.persistence.*;
import javax.validation.constraints.Size;


@EntityListeners(StudentEntityListener.class)
@Entity
@Table(name="STUDENT", schema = SchemaConstant.PRIMARY_SCHEMA)
@Data
@Slf4j
@ToString
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    @SequenceGenerator(name = "student_id_seq", sequenceName = SchemaConstant.PRIMARY_SCHEMA + ".student_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="STUDENT_NAME", length=5)
    @Size(max = 5)
    private String name;

    @Transient
    private Integer age;

    // other fields, getters and setters
    public static class StudentEntityBuilder{
        private String name = "defaultName";

        public StudentEntityBuilder name(String name) {
            // allow custom value by builder method
            this.name = name;
            return this;
        }
    }

    @PrePersist
    public void prePersist(){
        log.info("call prePersist for Student Entity: " + this);
    }

    public static void main(String[] args) {
        StudentEntity entity = StudentEntity.builder().build();
        System.out.println(entity);
    }
}
