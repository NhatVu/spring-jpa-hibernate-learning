package org.example.controller;

import org.example.entity.MessageEntity;
import org.example.entity.MessageTwoEntity;
import org.example.repository.two.MessageTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/two")
public class TwoController {
    @Autowired
    private MessageTwoRepository messageTwoRepository;

    @Autowired
    @Qualifier("twoDataSourceJdbcTemplate")
    private NamedParameterJdbcTemplate twoDataSourceJdbcTemplate;

    @GetMapping("/{text}")
    public MessageTwoEntity create(@PathVariable String text){
        MessageTwoEntity entity = new MessageTwoEntity();
        entity.setText(text);
        return messageTwoRepository.save(entity);
    }

    @GetMapping
    public List<MessageTwoEntity> getAll(){
        return messageTwoRepository.findAll();
    }

    @GetMapping("/mix-jpa-jdbc")
    public String mixJpaJdbc(){
        long id = 1l;
        // update: using jpa
        MessageTwoEntity entity = new MessageTwoEntity();
        entity.setId(id);
        entity.setText("Updated message!!!");

        MessageTwoEntity entity2 = new MessageTwoEntity();
        entity.setId(2l);
        entity.setText("Updated message!!!");

        MessageTwoEntity entity3 = new MessageTwoEntity();
        entity.setId(3l);
        entity.setText("Updated message!!!");
        messageTwoRepository.saveAll(Arrays.asList(entity, entity2, entity3));

        // delete: using jdbc
        twoDataSourceJdbcTemplate.getJdbcTemplate().execute("DELETE FROM learning_jpa_hibernate.messagetwo where id = 1");

        return "DONE";
    }
}
