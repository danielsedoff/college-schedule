package com.danielsedoff.college.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "<!doctype html><html><head></head><body><h1>Index</h1>"
                + "<DIV STYLE=\"font-size:24px;\">"
                + "<ul>"
                + "<li><a href=\"students.html\">Students</a></li>"
                + "<li><a href=\"professors.html\">Professors</a></li>"
                + "<li><a href=\"courses.html\">Courses</a></li>"
                + "<li><a href=\"groups.html\">Groups</a></li>"
                + "<li><a href=\"lessons.html\">Lessons</a></li>"
                + ""
                + "</ul>"
                + "</body></html>";
    }
}
