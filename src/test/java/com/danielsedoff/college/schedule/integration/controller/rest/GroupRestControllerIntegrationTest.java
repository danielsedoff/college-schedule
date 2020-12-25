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

import com.danielsedoff.college.schedule.controller.rest.GroupRestController;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService;

@SpringBootTest(classes = { GroupRestController.class }, 
                webEnvironment = WebEnvironment.RANDOM_PORT)
public class GroupRestControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    StudentService ss;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "create_tables.sql" })
    @Test
    public void testOneGroup() {
        assertEquals(this.restTemplate
                .getForObject("http://localhost:" + port + "/groups/2", Group.class)
                .getId(), 2);

    }

    @Test
    public void testAddGroup() {
        Group group = new Group();
        group.setId(14);
        group.setSpecialNotes("Fine Group");
        List<Student> students = new ArrayList<>();
        students.add(ss.getStudentById(2));
        group.setStudents(students);
        
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/groups", group, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    public void testGetGroupListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.
          getForEntity("http://localhost:" + port + "/groups", String.class);
        assertEquals(response.getStatusCode(), (HttpStatus.OK));
    }

}