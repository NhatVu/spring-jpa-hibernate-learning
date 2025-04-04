package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class Main{
    public static void main(String[] args) {
        // Get the java.class.path property
        String classpath = System.getProperty("java.class.path");
        System.out.println("Classpath:");
        System.out.println(classpath);

        SpringApplication.run(Main.class, args);
    }
}