package com.danielsedoff.college.schedule.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danielsedoff.college.schedule.model.Course;

public class TestJPABootstrapping {

    private static Logger logger = LoggerFactory.getLogger(TestJPABootstrapping.class);

    @Test
    public void bootstrapping() {
        logger.info("...bootstrapping...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.find(Course.class, 1);
        
        em.close();
        emf.close();
        
    }
    
    
}
