package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.service.StudentService;

@Controller
@ResponseBody
public class StudentListController {

    @Autowired
    private ProfessorDAO professordao;
    @Autowired
    private StudentDAO studentdao;
    @Autowired
    private GroupDAO groupdao;

    @GetMapping("/students")
    public String example() {
        StudentService ss = new StudentService(professordao, studentdao, groupdao);
        List<Integer> ids = ss.getStudentIdList();
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE HTML><HTML><BODY><DIV STYLE=\"font-size:24px;\">");
        result.append("<A HREF=\"index.html\">Back to the index page</A><UL>");
        for (Integer id : ids) {
            result.append("<LI>Student ID ");
            result.append(id);
            result.append(": ");
            result.append(ss.getStudentById(id).getName());
            result.append("</LI>");
        }
        result.append("</UL></DIV></BODY></HTML>");
        return result.toString();
    }
}
