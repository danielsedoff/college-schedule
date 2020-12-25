
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

import com.danielsedoff.college.schedule.dto.LessonDTO;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.LessonService;
import com.danielsedoff.college.schedule.service.ProfessorService;

@RestController
@RequestMapping("/lessons")
class LessonRestController {

    @Autowired
    private LessonService service;

    @Autowired
    private GroupService gservice;

    @Autowired
    private ProfessorService pservice;

    @GetMapping
    public List<LessonDTO> findAll() {
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
        return (result);
    }

    @GetMapping(value = "/{id}")
    public LessonDTO findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        Lesson lesson = RestPreconditions.checkFound(service.getLessonById(id));
        LessonDTO dto = new LessonDTO();
        dto.setEndTime(lesson.getEndTime());
        dto.setGroupId(lesson.getGroup().getId());
        dto.setId(lesson.getId());
        dto.setMode("update");
        dto.setProfessorId(lesson.getProfessor().getId());
        dto.setStartTime(lesson.getStartTime());
        return (dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody LessonDTO resource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "illegal Lesson instance input";
        }
        Lesson lesson = new Lesson();
        lesson.setDayschedule(new DaySchedule());
        lesson.setEndTime(resource.getEndTime());
        lesson.setStartTime(resource.getStartTime());
        lesson.setGroup(gservice.getGroupById(resource.getGroupId()));
        lesson.setProfessor(pservice.getProfessorById(resource.getProfessorId()));
        return service.createLesson(lesson) ? "success" : "Failed to update Lessons";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") int id, @Valid @RequestBody LessonDTO resource,
            BindingResult bindingResult) throws MyResourceNotFoundException {
        if (bindingResult.hasErrors()) {
            return "illegal Lesson instance input";
        }
        Lesson lesson = new Lesson();
        lesson.setDayschedule(new DaySchedule());
        lesson.setEndTime(resource.getEndTime());
        lesson.setStartTime(resource.getStartTime());
        lesson.setGroup(gservice.getGroupById(resource.getGroupId()));
        lesson.setProfessor(pservice.getProfessorById(resource.getProfessorId()));
        return service.updateLesson(id, lesson) ? "success" : "Failed to update Lessons";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteLessonById(id);
    }

}
