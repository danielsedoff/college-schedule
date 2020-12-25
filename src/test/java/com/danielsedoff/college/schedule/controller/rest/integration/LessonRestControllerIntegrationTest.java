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
import com.danielsedoff.college.schedule.dto.LessonDTO;
import com.danielsedoff.college.schedule.model.Lesson;

@SpringBootTest(classes = {
        Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class LessonRestControllerIntegrationTest {

    int port = 8080;

    private final String urlpart = "http://localhost:" + port + "/lessons";

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:/create_tables.sql" })
    @Test
    public void testOneLesson() {
        assertEquals(this.restTemplate.getForObject(urlpart + "/2", Lesson.class).getId(),
                2);

    }

    @Test
    public void testAddLesson() {
        LessonDTO lessondto = new LessonDTO();
        lessondto.setEndTime("2011-01-01 00:01");
        lessondto.setStartTime("2011-01-01 02:01");
        lessondto.setGroupId(2);
        lessondto.setProfessorId(2);
        lessondto.setId(1);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(urlpart,
                lessondto, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetLessonListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity(urlpart,
                String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testHttpDeleteLesson() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        Map<String, String> urlVariables = new HashMap<String, String>();
        urlVariables.put("", "");
        ResponseEntity<String> response = testRestTemplate.getForEntity(urlpart + "/3",
                String.class);
        assertEquals(200, response.getStatusCodeValue());
        testRestTemplate.delete(urlpart + "/3", urlVariables);
        response = testRestTemplate.getForEntity(urlpart + "/3", String.class);
        assertEquals(500, response.getStatusCodeValue());
    }

    @Test
    public void testHttpPutLesson() {

        int id = 2;

        LessonDTO lessondto = new LessonDTO();
        lessondto.setEndTime("2011-01-01 00:01");
        lessondto.setStartTime("2011-01-01 02:01");
        lessondto.setGroupId(2);
        lessondto.setProfessorId(2);
        lessondto.setId(1);

        HttpEntity<LessonDTO> dto = new HttpEntity<LessonDTO>(lessondto);

        ResponseEntity<String> response = restTemplate.exchange(urlpart + "/1",
                HttpMethod.PUT, dto, String.class, id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody());
    }

}