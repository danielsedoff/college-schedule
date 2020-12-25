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

import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService; 

@RestController
@RequestMapping("/students")
class StudentRestController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> findAll() {
        return service.getStudentList();
    }

    @GetMapping(value = "/{id}")
    public Student findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        return RestPreconditions.checkFound(service.getStudentById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Student resource) {
        if(null == resource) {
            return false;
        }
        return service.createStudent(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) int id, @RequestBody Student resource) throws MyResourceNotFoundException {
        if(null == resource) {
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

