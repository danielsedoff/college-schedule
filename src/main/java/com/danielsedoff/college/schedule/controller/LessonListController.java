package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.service.LessonService;

@Controller
public class LessonListController {

    @Autowired
    LessonService gs;

    @GetMapping("/lessonList")
    public String main(Model model) {
        List<Integer> ids = gs.getLessonIdList();
        List<Lesson> lessons = new ArrayList<>();

        for (int id : ids) {
            lessons.add(gs.getLessonById(id));
        }
        model.addAttribute("lessons", lessons);
        model.addAttribute("testvalue", "passed");

        return "lessonList";
    }

}
