package com.danielsedoff.college.schedule.integration.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.danielsedoff.college.schedule.controller.rest.CourseRestController;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService;

@SpringBootTest(classes = { CourseRestController.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseRestControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProfessorService pservice;

    
    @Sql({ "create_tables.sql" })
    @Test
    public void testOneCourse() {
        assertEquals(this.restTemplate
                .getForObject("http://localhost:" + port + "/courses/2", Course.class)
                .getId(), 2);

    }

    @Test
    public void testAddCourse() {
        Course course = new Course();
        course.setCourseDescription("A Big Course");
        course.setName("ABC");
        
        List<Professor> proflist = new ArrayList<>();
        proflist.add(pservice.getProfessorById(2));
        course.setProfessor(proflist);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/courses", course, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    public void testGetCourseListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.
          getForEntity("http://localhost:" + port + "/courses", String.class);
        assertEquals(response.getStatusCode(), (HttpStatus.OK));
    }
}