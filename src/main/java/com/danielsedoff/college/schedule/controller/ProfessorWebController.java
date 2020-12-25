package com.danielsedoff.college.schedule.controller;

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

import com.danielsedoff.college.schedule.dto.ProfessorDTO;
import com.danielsedoff.college.schedule.model.Professor;
import com.danielsedoff.college.schedule.service.ProfessorService;

@Controller
public class ProfessorWebController {

    @Autowired
    ProfessorService ps;

    @GetMapping("/professorList")
    public String getProfessors(Model model) {
        List<Professor> professors = ps.getProfessorList();
        if (null == professors) {
            model.addAttribute("result", "ERROR: the expected LIST is NULL.");
            return "resultPage";
        }
        model.addAttribute("professors", professors);
        model.addAttribute("testvalue", "passed");
        return "professorList";
    }

    @RequestMapping(value = "/professorForm", params = { "id" }, method = RequestMethod.GET)
    public String getIdParam(@RequestParam("id") int id, @ModelAttribute("professordto") ProfessorDTO professordto,
            Model model) {
        if (id == -1) {
            professordto.setMode("create");
            return "professorForm";
        }
        Professor professor = ps.getProfessorById(id);
        professordto.setId(id);
        professordto.setMode("update");
        professordto.setName(professor.getName());
        professordto.setNotes(professor.getSpecialNotes());
        professordto.setRanks(professor.getRanksTitles());
        model.addAttribute("testvalue", "passed");
        return "professorForm";
    }

    @PostMapping("/deleteProfessor")
    public String deleteProfessor(@ModelAttribute("professordto") ProfessorDTO professordto, Model model) {
        ps.deleteProfessor(professordto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createProfessor")
    public String createProfessor(@ModelAttribute("professordto") ProfessorDTO professordto, Model model) {
        Professor professor = new Professor();
        professor.setName(professordto.getName());
        professor.setSpecialNotes(professordto.getNotes());
        professor.setRanksTitles(professordto.getRanks());
        ps.createProfessor(professor);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateProfessor")
    public String updateProfessor(@ModelAttribute("professordto") ProfessorDTO professordto, Model model) {
        Professor professor = new Professor();
        professor.setId(professordto.getId());
        professor.setName(professordto.getName());
        professor.setSpecialNotes(professordto.getNotes());
        professor.setRanksTitles(professordto.getRanks());
        ps.updateProfessor(professor.getId(), professor);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }

}
