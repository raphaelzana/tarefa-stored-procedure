package com.example.dxc.springdatajpastoredprocedure.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@EnableJpaRepositories
@ComponentScan
@Configuration
public class AppConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("example-unit");
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }


    @PostConstruct
    void reset(){
        EntityManager em = entityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("Delete from PERSON")
          .executeUpdate();
        em.createNativeQuery("Delete from Person_HISTORY")
          .executeUpdate();
        em.getTransaction().commit();
    }
}