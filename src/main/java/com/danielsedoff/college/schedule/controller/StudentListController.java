package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService;

@Controller
public class StudentListController {

    @Autowired
    StudentService ss;

    @GetMapping("/students")
    public String main(Model model) {
        List<Integer> ids = ss.getStudentIdList();
        List<Student> students = new ArrayList<>();
        
        for (int id : ids) {
            students.add(ss.getStudentById(id));
        }
        model.addAttribute("students", students);
        model.addAttribute("testvalue", "passed");

        return "students";
    }
}
