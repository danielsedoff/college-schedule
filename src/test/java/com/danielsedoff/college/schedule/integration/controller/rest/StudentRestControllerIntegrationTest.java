package com.danielsedoff.college.schedule.integration.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.danielsedoff.college.schedule.controller.rest.StudentRestController;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.GroupService;

@SpringBootTest(classes = { StudentRestController.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentRestControllerIntegrationTest {
    @LocalServerPort
    private int port;
    
    
    @Autowired
    private GroupService gservice;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "create_tables.sql" })
    @Test
    public void testOneStudent() {
        assertEquals(this.restTemplate
                .getForObject("http://localhost:" + port + "/students/2", Student.class)
                .getId(), 2);

    }

    @Test
    public void testAddStudent() {
        Student student = new Student();

        student.setGroup(gservice.getGroupById(2));
        student.setName("Mike Tyson");
        student.setSchoolYear(3);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/students", student, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    @Test
    public void testGetStudentListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.
          getForEntity("http://localhost:" + port + "/students", String.class);
        assertEquals(response.getStatusCode(), (HttpStatus.OK));
    }

}