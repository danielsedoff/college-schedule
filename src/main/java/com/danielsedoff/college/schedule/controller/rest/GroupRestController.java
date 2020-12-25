package com.danielsedoff.college.schedule.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import com.danielsedoff.college.schedule.dto.GroupDTO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupRestController {

    @Autowired
    private GroupService service;

    @GetMapping
    public List<GroupDTO> findAll() {
        List<Group> groups = service.getGroupList();
        List<GroupDTO> result = new ArrayList<>();
        for (Group group : groups) {
            GroupDTO dto = new GroupDTO();
            dto.setName(group.getSpecialNotes());
            dto.setDescription(group.getSpecialNotes());
            dto.setId(group.getId());
            dto.setMode("update");
            result.add(dto);
        }
        return result;
    }

    @GetMapping(value = "/{id}")
    public GroupDTO findById(@PathVariable("id") int id)
            throws MyResourceNotFoundException {
        Group group = RestPreconditions.checkFound(service.getGroupById(id));
        GroupDTO dto = new GroupDTO();
        dto.setName(group.getSpecialNotes());
        dto.setDescription(group.getSpecialNotes());
        dto.setId(group.getId());
        dto.setMode("update");
        return dto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody GroupDTO resource) {
        Group group = new Group();
        group.setId(resource.getId());
        group.setSpecialNotes(resource.getDescription());
        group.setStudents(new ArrayList<Student>());
        return service.createGroup(group) ? "success" : "Failed to update Groups";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") int id,
            @Valid @RequestBody GroupDTO resource) throws MyResourceNotFoundException {
        Group group = new Group();
        group.setId(resource.getId());
        group.setSpecialNotes(resource.getDescription());
        group.setStudents(new ArrayList<Student>());
        return service.updateGroup(id, group) ? "success" : "Failed to update Groups";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteGroupById(id);
    }

}
