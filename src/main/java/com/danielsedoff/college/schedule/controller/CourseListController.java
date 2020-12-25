package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService;

@Controller
public class CourseListController {

    @Autowired
    private ProfessorDAO professordao;
    @Autowired
    private CourseDAO coursedao;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        CourseService cs = new CourseService(coursedao, professordao);
        List<Integer> ids = cs.getCourseIdList();
        List<Course> courses = new ArrayList<>();
        
        for (int id : ids) {
            courses.add(cs.getCourseById(id));
        }
        model.addAttribute("courses", courses);
        model.addAttribute("testvalue", "passed");
        return "courses";
    }
}
