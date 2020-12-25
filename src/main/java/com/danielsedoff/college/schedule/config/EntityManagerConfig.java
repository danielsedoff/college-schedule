package com.danielsedoff.college.schedule.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntityManagerConfig {
    @Bean
    public EntityManagerFactory getFactory() {
        return Persistence.createEntityManagerFactory("PU");
    }
}
