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

import com.danielsedoff.college.schedule.dto.CourseDTO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService; 

@RestController
@RequestMapping("/courses")
class CourseRestController {

    @Autowired
    private CourseService service;

    @GetMapping
    public String findAll() throws JsonProcessingException {
        List<Course> courses = service.getCourseList();
        List<CourseDTO> result = new ArrayList<>();
        for(Course course : courses) {
            CourseDTO dto = new CourseDTO();
            dto.setDescription(course.getCourseDescription());
            dto.setId(course.getId());
            dto.setMode("update");
            dto.setName(course.getName());
            dto.setProfessorId(course.getProfessors().get(0).getId());
            result.add(dto);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") int id) throws MyResourceNotFoundException, JsonProcessingException {
        Course course = RestPreconditions.checkFound(service.getCourseById(id));
        CourseDTO dto = new CourseDTO();
        dto.setDescription(course.getCourseDescription());
        dto.setId(id);
        dto.setMode("update");
        dto.setName(course.getName());
        dto.setProfessorId(course.getProfessors().get(0).getId());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Course resource) {
        if(null == resource) {
            return false;
        }
        return service.createCourse(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) int id, @RequestBody Course resource) throws MyResourceNotFoundException {
        if(null == resource) {
            throw new MyResourceNotFoundException();
        }
        service.updateCourse(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteCourseById(id);
    }

}

