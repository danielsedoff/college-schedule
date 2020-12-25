package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.danielsedoff.college.schedule.dto.CourseDTO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService;

@Controller
public class CourseWebController {

    @Autowired
    private CourseService cs;

    @GetMapping("/courseList")
    public String getCourses(Model model) {
        List<Integer> ids = cs.getCourseIdList();
        List<Course> courses = new ArrayList<>();

        for (int id : ids) {
            courses.add(cs.getCourseById(id));
        }
        model.addAttribute("courses", courses);
        model.addAttribute("testvalue", "passed");
        return "courseList";
    }

    @GetMapping(value = "/courseForm", params = { "id" })
    public String gedItParam(@RequestParam("id") int id,
            @ModelAttribute("coursedto") CourseDTO coursedto, Model model) {
        if (id == -1) {
            coursedto.setMode("create");
            return "courseForm";
        }

        Course course = cs.getCourseById(id);
        coursedto.setId(id);
        coursedto.setMode("update");
        coursedto.setName(course.getName());
        coursedto.setDescription(course.getCourseDescription());
        coursedto.setProfessorId(course.getProfessorId());
        model.addAttribute("testvalue", "passed");
        return "courseForm";
    }

    @PostMapping("/deleteCourse")
    public String deleteCourse(@ModelAttribute("coursedto") CourseDTO coursedto, Model model) {
        cs.deleteCourseById(coursedto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createCourse")
    public String createCourse(@ModelAttribute("coursedto") CourseDTO coursedto, Model model) {
        Course course = new Course();
        coursedto.setProfessorId(course.getProfessorId());

        course.setProfessorId(coursedto.getProfessorId());
        course.setCourseDescription(coursedto.getDescription());
        course.setName(coursedto.getName());
        cs.createCourse(course);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute("coursedto") CourseDTO coursedto, Model model) {
        Course course = new Course();
        course.setProfessorId(coursedto.getProfessorId());
        course.setId(coursedto.getId());
        course.setCourseDescription(coursedto.getDescription());
        course.setName(coursedto.getName());
        cs.updateCourse(coursedto.getId(), course);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }
}
