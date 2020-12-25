package com.danielsedoff.college.schedule.controller.rest;

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

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService; 

@RestController
@RequestMapping("/courses")
class CourseRestController {

    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> findAll() {
        return service.getCourseList();
    }

    @GetMapping(value = "/{id}")
    public Course findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        return RestPreconditions.checkFound(service.getCourseById(id));
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

