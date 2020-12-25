package com.danielsedoff.college.schedule.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.danielsedoff.college.schedule.config.EntityManagerConfig;

public abstract class EntityManagedDAO {
    @Autowired
    EntityManagerConfig emf;

    @Bean
    EntityManager getEntityManagerBean() {
        return emf.getFactory().createEntityManager();
    }
}
