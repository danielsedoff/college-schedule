
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

import com.danielsedoff.college.schedule.dto.StudentDTO;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.GroupService;
import com.danielsedoff.college.schedule.service.StudentService;

@RestController
@RequestMapping("/students")
class StudentRestController {

    @Autowired
    private StudentService service;

    @Autowired
    private GroupService gservice;

    @GetMapping
    public List<StudentDTO> findAll() {
        List<Student> students = service.getStudentList();
        List<StudentDTO> result = new ArrayList<>();
        for (Student student : students) {
            StudentDTO dto = new StudentDTO();
            dto.setId(student.getId());
            dto.setMode("update");
            dto.setName(student.getName());
            dto.setGroupId(student.getGroup().getId());
            dto.setSchoolYear(student.getSchoolYear());
            result.add(dto);
        }
        return (result);
    }

    @GetMapping(value = "/{id}")
    public StudentDTO findById(@PathVariable("id") int id) throws MyResourceNotFoundException {
        Student student = RestPreconditions.checkFound(service.getStudentById(id));
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setMode("update");
        dto.setName(student.getName());
        dto.setGroupId(student.getGroup().getId());
        dto.setSchoolYear(student.getSchoolYear());
        return (dto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Valid @RequestBody StudentDTO resource) {
        Student student = new Student();
        student.setGroup(gservice.getGroupById(resource.getGroupId()));
        student.setName(resource.getName());
        student.setSchoolYear(resource.getSchoolYear());
        return service.createStudent(student) ? "success" : "Failed to update Students";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") int id, @Valid @RequestBody StudentDTO resource,
            BindingResult bindingResult) throws MyResourceNotFoundException {
        Student student = new Student();
        student.setGroup(gservice.getGroupById(resource.getGroupId()));
        student.setName(resource.getName());
        student.setSchoolYear(resource.getSchoolYear());
        return service.updateStudent(resource.getId(), student) ? "success" : "Failed to update Students";
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.deleteStudentById(id);
    }

}
