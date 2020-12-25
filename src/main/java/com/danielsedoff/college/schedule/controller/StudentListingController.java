package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentListingController {
    
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody

    public String getStudentIds() {
        return "Oops, I don't know who my students are";
    }
    
}
