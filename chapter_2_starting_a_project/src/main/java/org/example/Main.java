package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Message;


public class Main {
    public static void main(String[] args) {
        // this is thread-safe, fetch/create entityManagerFactory by looking at <persistence-unit name="HelloWorldPU"> in persistence.xml file.
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");

        // EntityManager is not thread-safe, This means that each thread should obtain its instance, work with it, and close it at the end. [1]
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        // begin transaction
        tx.begin();
        Message message = new Message();
        message.setText("Hello World!23423");
        em.persist(message);
        tx.commit(); // commit transaction
        em.close(); // close entityManager
    }
}