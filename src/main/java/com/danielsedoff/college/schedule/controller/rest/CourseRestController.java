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

import com.danielsedoff.college.schedule.dto.CourseDTO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.CourseService;
import com.danielsedoff.college.schedule.service.ProfessorService;

@RestController
@RequestMapping("/courses")
class CourseRestController {

    @Autowired
    private CourseService service;
    
    @Autowired
    private ProfessorService ps;

    @GetMapping
    public List<CourseDTO> findAll() {
        List<Course> courses = service.getCourseList();
        List<CourseDTO> result = new ArrayList<>();
        for (Course course : courses) {
            CourseDTO dto = new CourseDTO();
            dto.setDescription(course.getCourseDescription());
            dto.setId(course.getId());
            dto.setMode("update");
            dto.setName(course.getName());
            dto.setProfessorId(course.getProfessors().get(0).getId());
            result.add(dto);
        }
        return result;
    }

    @GetMapping(value = "/{id}")
    public CourseDTO findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        Course course = RestPreconditions.checkFound(service.getCourseById(id));
        CourseDTO dto = new CourseDTO();
        dto.setDescription(course.getCourseDescription());
        dto.setId(id);
        dto.setMode("update");
        dto.setName(course.getName());
        dto.setProfessorId(course.getProfessors().get(0).getId());
        return dto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody CourseDTO resource) {
        Course course = new Course();
        course.setCourseDescription(resource.getDescription());
        course.setName(resource.getName());
        List<Professor> proflist = new ArrayList<>();
        proflist.add(ps.getProfessorById(resource.getProfessorId()));
        course.setProfessor(proflist);
        return service.createCourse(course) ? "success" : "Failed to update Courses";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") int id, @Valid @RequestBody CourseDTO resource)
            throws MyResourceNotFoundException {
        Course course = new Course();
        course.setCourseDescription(resource.getDescription());
        course.setName(resource.getName());
        List<Professor> proflist = new ArrayList<>();
        proflist.add(ps.getProfessorById(resource.getProfessorId()));
        course.setProfessor(proflist);
        return service.updateCourse(id, course) ? "success" : "Failed to update Courses";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteCourseById(id);
    }

}
