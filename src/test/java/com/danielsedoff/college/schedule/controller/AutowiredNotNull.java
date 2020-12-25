package com.danielsedoff.college.schedule.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import com.danielsedoff.college.schedule.config.AppConfig;


@ContextConfiguration(classes = AppConfig.class)
public class AutowiredNotNull {
    @Autowired
    StudentListingController studentListingController;

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Test
    public void StudentListingMustReturnSomething() throws IOException, SQLException {
        assertNotNull(studentListingController);
    }
    
    @Test
    public void jdbcTemplateNotNull() {
        assertNotNull(jdbcTemplate);
    }
}
