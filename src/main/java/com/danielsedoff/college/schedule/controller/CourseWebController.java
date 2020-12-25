package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danielsedoff.college.schedule.dto.CourseDTO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.CourseService;
import com.danielsedoff.college.schedule.service.ProfessorService;

@Controller
public class CourseWebController {

    @Autowired
    private CourseService cs;

    @Autowired
    private ProfessorService ps;

    @GetMapping("/courseList")
    public String getCourses(Model model) {
        List<Course> courses = cs.getCourseList();
        if (null == courses) {
            model.addAttribute("result", "ERROR: the expected LIST is NULL.");
            return "resultPage";
        }
        model.addAttribute("courses", courses);
        model.addAttribute("testvalue", "passed");
        return "courseList";
    }

    @GetMapping(value = "/courseForm", params = { "id" })
    public String gedItParam(@RequestParam("id") int id, @ModelAttribute("coursedto") CourseDTO coursedto,
            Model model) {
        if (id == -1) {
            coursedto.setMode("create");
            return "courseForm";
        }

        Course course = cs.getCourseById(id);
        coursedto.setId(id);
        coursedto.setMode("update");
        coursedto.setName(course.getName());
        coursedto.setDescription(course.getCourseDescription());
        coursedto.setProfessorId(course.getProfessors().get(0).getId());
        model.addAttribute("testvalue", "passed");
        return "courseForm";
    }

    @PostMapping("/deleteCourse")
    public String deleteCourse(@Valid @ModelAttribute("coursedto") CourseDTO coursedto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "courseForm";
        }

        cs.deleteCourseById(coursedto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createCourse")
    public String createCourse(@Valid @ModelAttribute("coursedto") CourseDTO coursedto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "courseForm";
        }

        Course course = new Course();
        List<Professor> professor = new ArrayList<>();
        professor.add(ps.getProfessorById(coursedto.getProfessorId()));
        course.setProfessor(professor);
        course.setCourseDescription(coursedto.getDescription());
        course.setName(coursedto.getName());
        cs.createCourse(course);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@Valid @ModelAttribute("coursedto") CourseDTO coursedto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "courseForm";
        }

        Course course = new Course();
        course.setCourseDescription(coursedto.getDescription());
        course.setName(coursedto.getName());
        List<Professor> professor = new ArrayList<>();
        professor.add(ps.getProfessorById(coursedto.getProfessorId()));
        course.setProfessor(professor);
        cs.updateCourse(coursedto.getId(), course);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }
}
