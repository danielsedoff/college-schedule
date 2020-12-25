package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentStatusController {
    @GetMapping("/view/student-status")
    public String showForm() {
        return "Student Status Message";
    }
 
}