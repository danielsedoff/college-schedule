package com.danielsedoff.college.schedule.controller;

import java.time.format.DateTimeFormatter;
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

import com.danielsedoff.college.schedule.dto.LessonDTO;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.LessonService;
import com.danielsedoff.college.schedule.service.ProfessorService;

@Controller
public class LessonWebController {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    LessonService ls;

    @Autowired
    ProfessorService ps;

    @GetMapping("/lessonList")
    public String getLessons(Model model) {
        List<Lesson> lessons = ls.getLessonList();
        model.addAttribute("lessons", lessons);
        model.addAttribute("testvalue", "passed");
        return "lessonList";
    }

    @RequestMapping(value = "/lessonForm", params = { "id" }, method = RequestMethod.GET)
    public String getIdParam(@RequestParam("id") int id, @ModelAttribute("lessondto") LessonDTO lessondto,
            Model model) {
        if (id == -1) {
            lessondto.setMode("create");
            return "lessonForm";
        }

        Lesson lesson = ls.getLessonById(id);
        lessondto.setId(id);
        lessondto.setMode("update");
        lessondto.setStartTime((lesson.getStartTime()));
        lessondto.setEndTime((lesson.getEndTime()));
        lessondto.setGroupId(lesson.getGroupId());
        int professorId = lesson.getProfessorId();
        lessondto.setProfessorId(professorId);
        return "lessonForm";
    }

    @PostMapping("/deleteLesson")
    public String deleteLesson(@ModelAttribute("lessondto") LessonDTO lessondto, Model model) {
        ls.deleteLessonById(lessondto.getId());
        model.addAttribute("result", "Your DELETE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/createLesson")
    public String createLesson(@ModelAttribute("lessondto") LessonDTO lessondto, Model model) {
        Lesson lesson = new Lesson();
        lesson.setEndTime((lessondto.getEndTime()));
        lesson.setStartTime((lessondto.getStartTime()));
        lesson.setGroupId(lessondto.getGroupId());
        lesson.setProfessorId(lessondto.getProfessorId());

        ls.createLesson(lesson);
        model.addAttribute("result", "Your CREATE request has been accepted by the server.");
        return "resultPage";
    }

    @PostMapping("/updateLesson")
    public String updateLesson(@ModelAttribute("lessondto") LessonDTO lessondto, Model model) {
        Lesson lesson = new Lesson();

        lesson.setId(lessondto.getId());
        lesson.setEndTime((lessondto.getEndTime()));
        lesson.setStartTime((lessondto.getStartTime()));
        lesson.setGroupId(lessondto.getGroupId());
        if (ps.getProfessorById(lessondto.getProfessorId()) == null) {
            model.addAttribute("result", "Error: there is no professor with ID " + lessondto.getProfessorId());
            return "resultPage";
        }
        lesson.setProfessorId(lessondto.getProfessorId());
        ls.updateLesson(lessondto.getId(), lesson);
        model.addAttribute("result", "Your UPDATE request has been accepted by the server.");
        return "resultPage";
    }
}
