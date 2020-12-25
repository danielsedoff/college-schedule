package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielsedoff.college.schedule.model.PageLink;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String main(Model model) {

        List<PageLink> links = new ArrayList<>();
        links.add(new PageLink("Student List", "studentList.html"));
        links.add(new PageLink("Professor List", "professorList.html"));
        links.add(new PageLink("Course List", "courseList.html"));
        links.add(new PageLink("Group List", "groupList.html"));
        links.add(new PageLink("Lesson List", "lessonList.html"));

        model.addAttribute("links", links);
        return "index.html";

    }
}
