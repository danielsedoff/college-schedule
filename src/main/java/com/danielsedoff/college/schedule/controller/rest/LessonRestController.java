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

import com.danielsedoff.college.schedule.dto.LessonDTO;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.LessonService;

@RestController
@RequestMapping("/lessons")
class LessonRestController {

    @Autowired
    private LessonService service;

    @GetMapping
    public String findAll() throws JsonProcessingException {
        List<Lesson> lessons = service.getLessonList();
        List<LessonDTO> result = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDTO dto = new LessonDTO();
            dto.setEndTime(lesson.getEndTime());
            dto.setGroupId(lesson.getGroup().getId());
            dto.setId(lesson.getId());
            dto.setMode("update");
            dto.setProfessorId(lesson.getProfessor().getId());
            dto.setStartTime(lesson.getStartTime());
            result.add(dto);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }

    @GetMapping(value = "/{id}")
    public String findById(@PathVariable("id") int id) throws MyResourceNotFoundException, JsonProcessingException {
        Lesson lesson = RestPreconditions.checkFound(service.getLessonById(id));
        LessonDTO dto = new LessonDTO();
        dto.setEndTime(lesson.getEndTime());
        dto.setGroupId(lesson.getGroup().getId());
        dto.setId(lesson.getId());
        dto.setMode("update");
        dto.setProfessorId(lesson.getProfessor().getId());
        dto.setStartTime(lesson.getStartTime());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Lesson resource) {
        if (null == resource) {
            return false;
        }
        return service.createLesson(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody Lesson resource) throws MyResourceNotFoundException {
        if (null == resource) {
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
