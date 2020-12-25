package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeControllerSample {
    @GetMapping("/animal")
    public String main(Model model) {
        model.addAttribute("field1", "boar");
        return "animal1";
    }
}
