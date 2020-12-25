package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService;

@Controller
public class ProfessorListController {

    @Autowired
    ProfessorService ps;

    @GetMapping("/professorList")
    public String main(Model model) {
        List<Integer> ids = ps.getProfessorIdList();
        List<Professor> professors = new ArrayList<>();
        
        for (int id : ids) {
            professors.add(ps.getProfessorById(id));
        }
        model.addAttribute("professors", professors);
        model.addAttribute("testvalue", "passed");

        return "professorList";
    }

}
