package com.danielsedoff.college.schedule.integration.controller.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.danielsedoff.college.schedule.controller.rest.ProfessorRestController;
import com.danielsedoff.college.schedule.model.Professor;

@SpringBootTest(classes = {
        ProfessorRestController.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProfessorRestControllerIntegrationTest {

    int port = 8080;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "create_tables.sql" })
    @Test
    public void testOneProfessor() {
        assertEquals(this.restTemplate.getForObject(
                "http://localhost:" + port + "/professors/2", Professor.class).getId(),
                2);

    }

    @Test
    public void testAddProfessor() {
        Professor professor = new Professor();

        professor.setName("Lenin");
        professor.setSpecialNotes("History Changer");
        professor.setRanksTitles("His Name Will Be Remembered");

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/professors", professor, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetProfessorListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/professors", String.class);
        assertEquals(response.getStatusCode(), (HttpStatus.OK));
    }

}