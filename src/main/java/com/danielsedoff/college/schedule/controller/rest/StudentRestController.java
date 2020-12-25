package com.danielsedoff.college.schedule.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.danielsedoff.college.schedule.dto.StudentDTO;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService;

@RestController
@RequestMapping("/students")
class StudentRestController {

    @Autowired
    private StudentService service;

    @GetMapping
    public String findAll() throws JsonProcessingException {
        List<Student> students = service.getStudentList();
        List<StudentDTO> result = new ArrayList<>();
        for (Student student : students) {
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setMode("update");
            dto.setName(student.getName());
            dto.setGroupId(student.getGroup().getId());
            dto.setSchoolYear(student.getSchoolYear());
            result.add(dto);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") int id) throws MyResourceNotFoundException, JsonProcessingException {
        Student student = RestPreconditions.checkFound(service.getStudentById(id));
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setMode("update");
        dto.setName(student.getName());
        dto.setGroupId(student.getGroup().getId());
        dto.setSchoolYear(student.getSchoolYear());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Student resource) {
        if (null == resource) {
            return false;
        }
        return service.createStudent(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Student resource) throws MyResourceNotFoundException {
        if (null == resource) {
            throw new MyResourceNotFoundException();
        }
        service.updateStudent(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteStudentById(id);
    }

}
