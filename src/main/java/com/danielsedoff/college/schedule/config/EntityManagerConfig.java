package com.danielsedoff.college.schedule.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityManagerConfig {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Bean
    EntityManager em() {
        return emf.createEntityManager();
    }
}
