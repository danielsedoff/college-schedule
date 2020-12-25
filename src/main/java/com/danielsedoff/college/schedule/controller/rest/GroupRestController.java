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

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.service.GroupService; 

@RestController
@RequestMapping("/groups")
class GroupRestController {

    @Autowired
    private GroupService service;

    @GetMapping
    public List<Group> findAll() {
        return service.getGroupList();
    }

    @GetMapping(value = "/{id}")
    public Group findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        return RestPreconditions.checkFound(service.getGroupById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Group resource) {
        if(null == resource) {
            return false;
        }
        return service.createGroup(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) int id, @RequestBody Group resource) throws MyResourceNotFoundException {
        if(null == resource) {
            throw new MyResourceNotFoundException();
        }
        service.updateGroup(id, resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteGroupById(id);
    }

}

