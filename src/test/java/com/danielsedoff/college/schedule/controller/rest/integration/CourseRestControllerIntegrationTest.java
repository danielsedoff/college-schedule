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
import com.danielsedoff.college.schedule.dto.CourseDTO;
import com.danielsedoff.college.schedule.model.Course;

@SpringBootTest(classes = {
        Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseRestControllerIntegrationTest {

    int port = 8080;
    private final String urlpart = "http://localhost:" + port + "/courses";
    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:/create_tables.sql" })
    @Test
    public void testOneCourse() {
        assertEquals(this.restTemplate.getForObject(urlpart + "/2", Course.class).getId(),
                2);

    }

    @Test
    public void testAddCourse() {
        CourseDTO coursedto = new CourseDTO();
        coursedto.setDescription("A Big Course");
        coursedto.setName("ABC");

        coursedto.setProfessorId(2);
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(urlpart,
                coursedto, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetCourseListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity(urlpart,
                String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testHttpDeleteCourse() {
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
    public void testHttpPutCourse() {

        int id = 2;

        CourseDTO coursedto = new CourseDTO();
        coursedto.setDescription("A Smaller Course");
        coursedto.setName("ASC");
        coursedto.setProfessorId(2);
        coursedto.setId(2);

        HttpEntity<CourseDTO> dto = new HttpEntity<CourseDTO>(coursedto);

        ResponseEntity<String> response = restTemplate.exchange(urlpart + "/2",
                HttpMethod.PUT, dto, String.class, id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody());
    }
}