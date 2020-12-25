
package com.danielsedoff.college.schedule.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danielsedoff.college.schedule.dto.ProfessorDTO;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService;

@RestController
@RequestMapping("/professors")
class ProfessorRestController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public List<ProfessorDTO> findAll() {
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
        return (result);
    }

    @GetMapping(value = "/{id}")
    public ProfessorDTO findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        Professor professor = RestPreconditions.checkFound(service.getProfessorById(id));
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setMode("update");
        dto.setName(professor.getName());
        dto.setNotes(professor.getSpecialNotes());
        dto.setRanks(professor.getRanksTitles());
        return (dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody ProfessorDTO resource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "illegal Professor instance input";
        }
        Professor professor = new Professor();
        professor.setName(resource.getName());
        professor.setRanksTitles(resource.getRanks());
        professor.setSpecialNotes(resource.getNotes());
        return service.createProfessor(professor) ? "success" : "Failed to update Professors";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") int id, @Valid @RequestBody ProfessorDTO resource,
            BindingResult bindingResult) throws MyResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            return "illegal Professor instance input";
        }
        Professor professor = new Professor();
        professor.setName(resource.getName());
        professor.setRanksTitles(resource.getRanks());
        professor.setSpecialNotes(resource.getNotes());
        return service.updateProfessor(id, professor) ? "success" : "Failed to update Professors";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteProfessorById(id);
    }

}
