package org.example.controller;

import org.example.entity.MessageEntity;
import org.example.repository.one.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/one")
public class OneController {
    @Autowired
    private MessageRepository messageRepository;
    @PostMapping("/{text}")
    public MessageEntity create(@PathVariable String text){
        MessageEntity entity = new MessageEntity();
        entity.setText(text);
        MessageEntity res = messageRepository.save(entity);
        return res;
    }

    @GetMapping
    public List<MessageEntity> getAll(){
        return messageRepository.findAll();
    }
}
