package com.danielsedoff.college.schedule.config;

import javax.sql.DataSource;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.danielsedoff.college.schedule.service.CourseService;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.LessonService;
import com.danielsedoff.college.schedule.service.ProfessorService;
import com.danielsedoff.college.schedule.service.StudentService;

@Profile("test")
@Configuration
public class TestWebConfig extends WebConfig {
    @Bean
    public CourseService courseService() {
        return Mockito.mock(CourseService.class);
    }

    @Bean
    public GroupService groupService() {
        return Mockito.mock(GroupService.class);
    }

    @Bean
    public LessonService lessonService() {
        return Mockito.mock(LessonService.class);
    }

    @Bean
    public ProfessorService professorService() {
        return Mockito.mock(ProfessorService.class);
    }

    @Bean
    public StudentService studentService() {
        return Mockito.mock(StudentService.class);
    }
    
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }

}
