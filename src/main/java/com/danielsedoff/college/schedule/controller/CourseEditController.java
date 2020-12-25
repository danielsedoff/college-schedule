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
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.CourseService;

@Controller
public class CourseEditController {

    @Autowired
    private CourseService cs;

    String getParam(String haystack, String needle) {
        int startPosition = haystack.indexOf(needle + "=");
        if (startPosition == -1) {
            return null;
        }
        int endPosition = haystack.indexOf("&", startPosition);
        if ((endPosition == -1) || (endPosition - startPosition < 1)) {
            return null;
        }
        String result = haystack.substring(startPosition + needle.length() + 1, endPosition);
        return result;
    }

    @PostMapping("/courseEdit")
    @ResponseBody
    public String editCourses(HttpServletRequest request, HttpServletResponse response,
            Model model) {

        String userRequest = request.getParameter("encoded");
        /* DEBUG */ System.out.println("userRequest: " + userRequest);
        String mode = getParam(userRequest, "mode");
        String name = getParam(userRequest, "name");
        String idInput = getParam(userRequest, "idinput");
        String description = getParam(userRequest, "description");
        String connectedId1 = getParam(userRequest, "connectedid1");

        if (mode.equals("create")) {

            List<Professor> professors = new ArrayList<Professor>();
            Professor prof = new Professor();
            prof.setId(Integer.parseInt(connectedId1));
            professors.add(prof);

            Course course = new Course();
            course.setProfessors(professors);
            course.setCourseDescription(description);
            course.setName(name);
            cs.createCourse(course);
            return "Your CREATE request has been accepted by the server.";
        }

        if (mode.equals("update")) {

            List<Professor> professors = new ArrayList<Professor>();
            Professor prof = new Professor();
            prof.setId(Integer.parseInt(connectedId1));
            professors.add(prof);

            Course course = new Course();
            course.setId(Integer.parseInt(idInput));
            course.setProfessors(professors);
            course.setCourseDescription(description);
            course.setName(name);
            cs.updateCourse(Integer.parseInt(idInput), course);
            return "Your UPDATE request has been accepted by the server.";
        }

        if (mode.equals("delete")) {

            cs.deleteCourseById(Integer.parseInt(idInput));
            return "Your DELETE request has been accepted by the server.";
        }

        return "The server has recieved an unsupported mode command: " + mode;
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
