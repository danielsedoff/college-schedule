package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.service.CourseService;

@Controller
public class CourseEditController {

    private static final String DELIMITER = "; ";
    @Autowired
    private CourseService cs;

    @PostMapping("/courseEdit")
    @ResponseBody
    public String courseEditStub(HttpServletRequest request,
            HttpServletResponse response, Model model) {
        String mode = request.getParameter("mode");
        String courseid = request.getParameter("courseid");
        String coursedescription = request.getParameter("coursedescription");
        String professorid = request.getParameter("professorid");

        return (mode + DELIMITER + courseid + DELIMITER + coursedescription + DELIMITER + professorid); 
    }

    public String getCourses(Model model) {
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
