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

import com.danielsedoff.college.schedule.controller.rest.LessonRestController;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.ProfessorService;

@SpringBootTest(classes = { LessonRestController.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class LessonRestControllerIntegrationTest {
    @LocalServerPort
    private int port;
    
    @Autowired
    private GroupService gservice;

    @Autowired
    private ProfessorService pservice;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "create_tables.sql" })
    @Test
    public void testOneLesson() {
        assertEquals(this.restTemplate
                .getForObject("http://localhost:" + port + "/lessons/2", Lesson.class)
                .getId(), 2);

    }

    @Test
    public void testAddLesson() {
        Lesson lesson = new Lesson();
        lesson.setDayschedule(new DaySchedule());
        lesson.setEndTime("2011-01-01 00:01");
        lesson.setStartTime("2011-01-01 02:01");
        lesson.setGroup(gservice.getGroupById(2));
        lesson.setProfessor(pservice.getProfessorById(2));
        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/lessons", lesson, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }
    
    @Test
    public void testGetLessonListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.
          getForEntity("http://localhost:" + port + "/lessons", String.class);
        assertEquals(response.getStatusCode(), (HttpStatus.OK));
    }

}