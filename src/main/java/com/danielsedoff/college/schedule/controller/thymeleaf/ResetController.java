package com.danielsedoff.college.schedule.controller.thymeleaf;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.danielsedoff.college.schedule.repositories.SqlScriptRunner;

@Controller
public class ResetController implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(ResetController.class);

    private static final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    private SqlScriptRunner ibatisRead;

    final String success = "Congratulations, you have RESET the whole database.";
    final String failure = "Sorry, database RESET could not be accomplished.";
    String result = null;

    @GetMapping("/resetProject")
    
    public String main(Model model) {

        try {
            ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
            result = success;
        } catch (IOException | SQLException e) {
            logger.error("ibatis error: " + e.getMessage());
            result = failure;
        }

        model.addAttribute("result", result);
        return "resultPage";

    }
}