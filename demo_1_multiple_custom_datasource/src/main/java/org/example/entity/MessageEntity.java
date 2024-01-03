package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "message", schema = "learning_jpa_hibernate")
@Data
public class MessageEntity {
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
