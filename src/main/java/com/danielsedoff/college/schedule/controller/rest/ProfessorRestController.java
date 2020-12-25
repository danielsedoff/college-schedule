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

import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService; 

@RestController
@RequestMapping("/professors")
class ProfessorRestController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public List<Professor> findAll() {
        return service.getProfessorList();
    }

    @GetMapping(value = "/{id}")
    public Professor findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        return RestPreconditions.checkFound(service.getProfessorById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Professor resource) {
        if(null == resource) {
            return false;
        }
        return service.createProfessor(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) int id, @RequestBody Professor resource) throws MyResourceNotFoundException {
        if(null == resource) {
            throw new MyResourceNotFoundException();
        }
        service.updateProfessor(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteProfessorById(id);
    }

}

