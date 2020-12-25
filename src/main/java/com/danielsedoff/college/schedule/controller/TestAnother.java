package com.danielsedoff.college.schedule.controller;

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
public class TestAnother {

    @Autowired
    private ProfessorDAO professordao;
    @Autowired
    private StudentDAO studentdao;
    @Autowired
    private GroupDAO groupdao;

    @GetMapping("/stud1")
    public String example() {
        StudentService ss = new StudentService(professordao, studentdao, groupdao);
        return ss.getStudentById(1).getName();
    }
}
