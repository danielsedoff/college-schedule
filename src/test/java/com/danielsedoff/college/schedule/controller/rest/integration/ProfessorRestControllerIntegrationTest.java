package com.danielsedoff.college.schedule.controller.rest.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.danielsedoff.college.schedule.Application;
import com.danielsedoff.college.schedule.dto.ProfessorDTO;
import com.danielsedoff.college.schedule.model.Professor;

@SpringBootTest(classes = {
        Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProfessorRestControllerIntegrationTest {

    int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:/create_tables.sql" })
    @Test
    public void testOneProfessor() {
        assertEquals(this.restTemplate.getForObject(
                "http://localhost:" + port + "/professors/2", Professor.class).getId(),
                2);
    }

    @Test
//    @Order(1)
    public void testAddProfessor() {
        ProfessorDTO professordto = new ProfessorDTO();

        professordto.setName("Tom");
        professordto.setNotes("Big Cat");
        professordto.setRanks("Wants To Catch Jerry");

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/professors", professordto, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
//    @Order(2)
    public void testGetProfessorListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/professors/", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testHttpDeleteProfessor() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("", "");
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/professors/3", String.class);
        assertEquals(200, response.getStatusCodeValue());
        testRestTemplate.delete("http://localhost:" + port + "/professors/3",
                urlVariables);
        response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/professors/3", String.class);
        assertEquals(500, response.getStatusCodeValue());
    }

    @Test
    public void testHttpPutProfessor() {

        int id = 2;

        ProfessorDTO professordto = new ProfessorDTO();
        professordto.setName("Tom");
        professordto.setNotes("Big Cat");
        professordto.setRanks("Wants To Catch Jerry");
        professordto.setId(1);

        HttpEntity<ProfessorDTO> dto = new HttpEntity<ProfessorDTO>(professordto);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/professors/1", HttpMethod.PUT, dto,
                String.class, id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody());
    }

}