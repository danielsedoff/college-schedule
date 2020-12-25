package com.danielsedoff.college.schedule.controller;

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

import com.danielsedoff.college.schedule.dao.SqlScriptRunner;
import com.danielsedoff.college.schedule.model.PageLink;

@Controller
public class MainPageController {
    private static Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @Autowired
    private SqlScriptRunner ibatisRead;

    @GetMapping("/")
    public String main(Model model) {

        List<PageLink> links = new ArrayList<>();
        links.add(new PageLink("Student List", "studentList.html"));
        links.add(new PageLink("Professor List", "professorList.html"));
        links.add(new PageLink("Course List", "courseList.html"));
        links.add(new PageLink("Group List", "groupList.html"));
        links.add(new PageLink("Lesson List", "lessonList.html"));

        model.addAttribute("links", links);

        try {
            final String SQL_FILE_NAME = "create_tables.sql";
            ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
        } catch (IOException | SQLException e) {
            logger.error("ibatis error: " + e.getMessage());
        }

        return "index.html";

    }
}
