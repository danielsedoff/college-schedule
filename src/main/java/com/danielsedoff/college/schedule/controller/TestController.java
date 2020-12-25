package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("/test")
    public ModelAndView helloWorld() {

        String message = "Test Successful";
        return new ModelAndView("welcome", "message", message);
    }
}
