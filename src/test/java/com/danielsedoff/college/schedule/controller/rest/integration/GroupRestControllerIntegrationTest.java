package com.danielsedoff.college.schedule.controller.rest.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.danielsedoff.college.schedule.dto.GroupDTO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService;

@SpringBootTest(classes = {
        Application.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GroupRestControllerIntegrationTest {

    int port = 8080;

    private final String urlpart = "http://localhost:" + port + "/groups";

    @Autowired
    StudentService ss;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({ "classpath:/create_tables.sql" })
    @Test
    public void testOneGroup() {
        assertEquals(this.restTemplate.getForObject(urlpart + "/2", Group.class).getId(),
                2);

    }

    @Test
    public void testAddGroup() {
        GroupDTO groupdto = new GroupDTO();
        groupdto.setId(14);
        groupdto.setDescription("Fine Group");
        List<Student> students = new ArrayList<>();
        students.add(ss.getStudentById(2));
        groupdto.setName("FG");

        ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(urlpart,
                groupdto, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testGetGroupListAvailability() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity(urlpart,
                String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testHttpDeleteGroup() {
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
    public void testHttpPutGroup() {

        int id = 2;

        GroupDTO groupdto = new GroupDTO();
        groupdto.setId(2);
        groupdto.setDescription("Fine Group");
        List<Student> students = new ArrayList<>();
        students.add(ss.getStudentById(2));
        groupdto.setName("FG");

        HttpEntity<GroupDTO> dto = new HttpEntity<GroupDTO>(groupdto);

        ResponseEntity<String> response = restTemplate.exchange(urlpart + "/2",
                HttpMethod.PUT, dto, String.class, id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("success", response.getBody());
    }

}