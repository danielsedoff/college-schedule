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

import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.LessonService; 

@RestController
@RequestMapping("/lessons")
class LessonRestController {

    @Autowired
    private LessonService service;

    @GetMapping
    public List<Lesson> findAll() {
        return service.getLessonList();
    }

    @GetMapping(value = "/{id}")
    public Lesson findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        return RestPreconditions.checkFound(service.getLessonById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Lesson resource) {
        if(null == resource) {
            return false;
        }
        return service.createLesson(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) int id, @RequestBody Lesson resource) throws MyResourceNotFoundException {
        if(null == resource) {
            throw new MyResourceNotFoundException();
        }
        service.updateLesson(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteLessonById(id);
    }

}

