package com.example.dxc.springdatajpastoredprocedure.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import com.example.dxc.springdatajpastoredprocedure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;


@SpringBootApplication
@ComponentScan
public class ExampleMain {


    @Autowired
    private ExampleClient exampleClient;

    public static void main(String[] args) {
        SpringApplication.run(ExampleMain.class, args);
        //AnnotationConfigApplicationContext context =
                //new AnnotationConfigApplicationContext(AppConfig.class);
        //ExampleClient exampleClient = context.getBean(ExampleClient.class);
        //exampleClient.run();
        //context.close();        
    }

    @EventListener
	public void onReady(ApplicationReadyEvent event) throws FileNotFoundException, IOException {
        try {
            exampleClient.run();
        } catch(Exception e) {}
    }
    
}