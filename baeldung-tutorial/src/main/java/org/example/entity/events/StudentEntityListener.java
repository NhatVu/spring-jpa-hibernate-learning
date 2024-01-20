package org.example.entity.events;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.StudentEntity;

import javax.persistence.PostPersist;

@Slf4j
public class StudentEntityListener {
    @PostPersist
    public void postPersist(StudentEntity entity){
        log.info("call PostPersist for Student Entity:: " + entity);
    }

}
