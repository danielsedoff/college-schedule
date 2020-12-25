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
import com.danielsedoff.college.schedule.model.Professor;
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

    @RequestMapping(value = "/courseForm", params = { "id" }, method = RequestMethod.GET)
    public String gedItParam(@RequestParam("id") int id,
            @ModelAttribute("coursedto") CourseDTO coursedto, Model model) {
        if (id == -1) {
            return "courseForm";
        }

        Course course = cs.getCourseById(id);
        coursedto.setId(id);
        coursedto.setMode("update");
        coursedto.setName(course.getName());
        coursedto.setDescription(course.getCourseDescription());
        List<Professor> profs = course.getProfessors();
        if (null != profs) {
            int profId = profs.get(0).getId();
            coursedto.setConnectedId1(profId);
        } else {
            coursedto.setConnectedId1(0);
        }
        model.addAttribute("testvalue", "passed");
        return "courseForm";
    }

    @PostMapping("/courseForm")
    public String editCourses(@ModelAttribute("coursedto") CourseDTO coursedto, Model model) {

        if (null != coursedto.getMode() && coursedto.getMode().equals("delete")) {
            cs.deleteCourseById(coursedto.getId());
            model.addAttribute("result", "Your DELETE request has been accepted by the server.");
            return "resultPage";
        }

        if (null != coursedto.getMode() && coursedto.getMode().equals("create")) {
            Course course = new Course();

            if (coursedto.getConnectedId1() > 0) {
                List<Professor> professors = new ArrayList<Professor>();
                Professor prof = new Professor();
                prof.setId(coursedto.getConnectedId1());
                professors.add(prof);
                course.setProfessors(professors);
            }
            course.setCourseDescription(coursedto.getDescription());
            course.setName(coursedto.getName());
            cs.createCourse(course);
            model.addAttribute("result", "Your CREATE request has been accepted by the server.");
            return "resultPage";
        }

        if (null != coursedto.getMode() && coursedto.getMode().equals("update")) {
            Course course = new Course();

            if (coursedto.getConnectedId1() > 0) {
                List<Professor> professors = new ArrayList<Professor>();
                Professor prof = new Professor();
                prof.setId(coursedto.getConnectedId1());
                professors.add(prof);
                course.setProfessors(professors);
            }

            course.setId(coursedto.getId());
            course.setCourseDescription(coursedto.getDescription());
            course.setName(coursedto.getName());
            cs.updateCourse(coursedto.getId(), course);
            model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
            return "resultPage";
        }

        model.addAttribute("result", "The server has recieved an unsupported request.");
        return "resultPage";
    }

}
