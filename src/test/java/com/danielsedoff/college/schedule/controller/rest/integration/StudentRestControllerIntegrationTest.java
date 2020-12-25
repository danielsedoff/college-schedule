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
import com.danielsedoff.college.schedule.dto.StudentDTO;
import com.danielsedoff.college.schedule.model.Student;

@SpringBootTest(classes = {
        Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentRestControllerIntegrationTest {

    int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:/create_tables.sql" })
    @Test
    public void testOneStudent() {
        assertEquals(this.restTemplate
                .getForObject("http://localhost:" + port + "/students/2", Student.class)
                .getId(), 2);
    }

    @Test
    public void testAddStudent() {
        StudentDTO studentdto = new StudentDTO();

        studentdto.setGroupId(2);
        studentdto.setName("Mike Tyson");
        studentdto.setSchoolYear(3);

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/students", studentdto, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetStudentListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/students", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testHttpDeleteStudent() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("", "");
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/students/3", String.class);
        assertEquals(200, response.getStatusCodeValue());
        testRestTemplate.delete("http://localhost:" + port + "/students/3", urlVariables);
        response = testRestTemplate
                .getForEntity("http://localhost:" + port + "/students/3", String.class);
        assertEquals(500, response.getStatusCodeValue());
    }

    @Test
    public void testHttpPutStudent() {

        int id = 2;

        StudentDTO studDto = new StudentDTO();
        studDto.setGroupId(1);
        studDto.setName("Mike Tyson");
        studDto.setSchoolYear(3);
        studDto.setId(1);

        HttpEntity<StudentDTO> dto = new HttpEntity<StudentDTO>(studDto);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/students/1", HttpMethod.PUT, dto,
                String.class, id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody());
    }

}