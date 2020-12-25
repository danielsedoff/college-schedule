package com.danielsedoff.college.schedule.controller;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.service.CourseService;

@Profile("test")
@Configuration
public class NameServiceTestConfiguration {
    @Bean
    @Primary
    public CourseService courseService() {
        return Mockito.mock(CourseService.class);
    }
    
    @Bean
    @Primary
    public CourseDAO coursedao() {
        return Mockito.mock(CourseDAO.class);
    }
    
}