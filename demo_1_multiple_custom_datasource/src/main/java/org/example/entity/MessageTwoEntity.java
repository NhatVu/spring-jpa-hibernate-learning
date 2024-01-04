package org.example.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Table(name = "messageTwo", schema = "learning_jpa_hibernate")
@Data
public class MessageTwoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_two_id_seq")
    @SequenceGenerator(name = "message_two_id_seq", sequenceName = "learning_jpa_hibernate.message_two_id_seq", allocationSize = 1)
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
