package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Message;

import java.util.List;

public class MainUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // equal = SELECT * from MESSAGE
        // this is JPQL (Java Persistence Query Language), he Message in the query string doesn’t refer to the database table name, but to the persistent class name.
        List<Message> messages =
                em.createQuery("select m from Message m").getResultList();

        System.out.println("before update: " + messages.get(0));
        assert messages.get(0).getText().equals("Hello World! update");
        messages.get(0).setText("Take ");

        tx.commit();
        em.close();
    }
}