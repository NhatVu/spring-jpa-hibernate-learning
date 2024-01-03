package org.example.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "messageTwo", schema = "learning_jpa_hibernate")
@Data
public class MessageTwoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String text;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
