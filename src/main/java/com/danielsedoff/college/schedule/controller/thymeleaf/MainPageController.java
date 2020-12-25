package com.danielsedoff.college.schedule.controller.thymeleaf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.danielsedoff.college.schedule.model.PageLink;
import com.danielsedoff.college.schedule.repositories.SqlScriptRunner;

@Controller
public class MainPageController implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(MainPageController.class);

    private static final String SQL_FILE_NAME = "create_tables.sql";
    
    @Autowired
    private SqlScriptRunner ibatisRead;

    @GetMapping("/")
    public String main(Model model) {

        List<PageLink> links = new ArrayList<>();
        links.add(new PageLink("Student List", "studentList", "/images/student.png"));
        links.add(new PageLink("Professor List", "professorList", "/images/professor.png"));
        links.add(new PageLink("Course List", "courseList", "/images/course.png"));
        links.add(new PageLink("Group List", "groupList", "/images/group.png"));
        links.add(new PageLink("Lesson List", "lessonList", "/images/lesson.png"));

        model.addAttribute("links", links);

        try {
            ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
        } catch (IOException | SQLException e) {
            logger.error("ibatis error: " + e.getMessage());
        }

        return "index";

    }
}
