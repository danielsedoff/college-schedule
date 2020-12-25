package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.service.CourseService;

@Controller
@ResponseBody
public class CourseListController {

    @Autowired
    private ProfessorDAO professordao;
    @Autowired
    private CourseDAO coursedao;

    @GetMapping("/courses")
    public String example() {
        CourseService cs = new CourseService(coursedao, professordao);
        List<Integer> ids = cs.getCourseIdList();
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE HTML><HTML><BODY><DIV STYLE=\"font-size:24px;\">");
        result.append("<A HREF=\"index.html\">Back to the index page</A><UL>");
        for (Integer id : ids) {
            result.append("<LI>Course ID ");
            result.append(id);
            result.append(": ");
            result.append(cs.getCourseById(id).getName());
            result.append("</LI>");
        }
        result.append("</UL></DIV></BODY></HTML>");
        return result.toString();
    }
}
