package com.danielsedoff.college.schedule.controller.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.danielsedoff.college.schedule.model.PageLink;

@Controller
public class MainPageController implements WebMvcConfigurer {

    @GetMapping("/")
    public String main(Model model) {

        List<PageLink> links = new ArrayList<>();
        links.add(new PageLink("Lesson Schedule", "lessonList", "/images/lesson.png"));
        links.add(new PageLink("Student List", "studentList", "/images/student.png"));
        links.add(new PageLink("Professor List", "professorList", "/images/professor.png"));
        links.add(new PageLink("Course List", "courseList", "/images/course.png"));
        links.add(new PageLink("Group List", "groupList", "/images/group.png"));
        links.add(new PageLink("Reset All Data", "resetProject", "/images/reset.png"));

        model.addAttribute("links", links);

        return "index";

    }
}
