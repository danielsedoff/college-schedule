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

import com.danielsedoff.college.schedule.dto.ProfessorDTO;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService;

@RestController
@RequestMapping("/professors")
class ProfessorRestController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public String findAll() throws JsonProcessingException {
        List<Professor> professors = service.getProfessorList();
        List<ProfessorDTO> result = new ArrayList<>();
        for (Professor professor : professors) {
            ProfessorDTO dto = new ProfessorDTO();
            dto.setId(professor.getId());
            dto.setMode("update");
            dto.setName(professor.getName());
            dto.setNotes(professor.getSpecialNotes());
            dto.setRanks(professor.getRanksTitles());
            result.add(dto);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") int id) throws MyResourceNotFoundException, JsonProcessingException {
        Professor professor = RestPreconditions.checkFound(service.getProfessorById(id));
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setMode("update");
        dto.setName(professor.getName());
        dto.setNotes(professor.getSpecialNotes());
        dto.setRanks(professor.getRanksTitles());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Professor resource) {
        if (null == resource) {
            return false;
        }
        return service.createProfessor(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Professor resource) throws MyResourceNotFoundException {
        if (null == resource) {
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
