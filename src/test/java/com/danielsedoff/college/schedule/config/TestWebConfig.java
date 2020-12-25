package com.danielsedoff.college.schedule.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.service.CourseService;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.LessonService;
import com.danielsedoff.college.schedule.service.ProfessorService;
import com.danielsedoff.college.schedule.service.StudentService;

@Profile("test")
@Configuration
public class TestWebConfig extends WebConfig {
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

    @Bean
    @Primary
    public GroupService groupService() {
        return Mockito.mock(GroupService.class);
    }

    @Bean
    @Primary
    public GroupDAO groupdao() {
        return Mockito.mock(GroupDAO.class);
    }

    @Bean
    @Primary
    public LessonService lessonService() {
        return Mockito.mock(LessonService.class);
    }

    @Bean
    @Primary
    public LessonDAO lessondao() {
        return Mockito.mock(LessonDAO.class);
    }

    @Bean
    @Primary
    public ProfessorService professorService() {
        return Mockito.mock(ProfessorService.class);
    }

    @Bean
    @Primary
    public ProfessorDAO professordao() {
        return Mockito.mock(ProfessorDAO.class);
    }

    @Bean
    @Primary
    public StudentService studentService() {
        return Mockito.mock(StudentService.class);
    }

    @Bean
    @Primary
    public StudentDAO studentdao() {
        return Mockito.mock(StudentDAO.class);
    }

}
