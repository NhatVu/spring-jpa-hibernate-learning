package org.example.controller;

import org.example.entity.MessageEntity;
import org.example.entity.MessageTwoEntity;
import org.example.repository.two.MessageTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/two")
public class TwoController {
    @Autowired
    private MessageTwoRepository messageTwoRepository;
    @PostMapping("/{text}")
    public MessageTwoEntity create(@PathVariable String text){
        MessageTwoEntity entity = new MessageTwoEntity();
        entity.setText(text);
        return messageTwoRepository.save(entity);
    }

    @GetMapping
    public List<MessageTwoEntity> getAll(){
        return messageTwoRepository.findAll();
    }
}
