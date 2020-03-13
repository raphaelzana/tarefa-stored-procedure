package com.example.dxc.springdatajpastoredprocedure.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.persistence.EntityManagerFactory;

public class ExampleMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleClient exampleClient = context.getBean(ExampleClient.class);
        exampleClient.run();
        context.close();        
    }
}