package com.danielsedoff.college.schedule.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.SqlScriptRunner;
import com.danielsedoff.college.schedule.service.StudentService;

@Component
public class StudentListingController {
    
    final String SQL_FILE_NAME = "create_tables.sql";

    @Autowired
    SqlScriptRunner ibatisRead;
    @Autowired
    StudentService studentService;
    
    private static Logger logger = LoggerFactory.getLogger(StudentListingController.class);

    public String getStudentIds() {
        try {
            ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
        } catch (IOException e) {
            logger.error("ibatis file reading error", e);
        } catch (SQLException e) {
            logger.error("ibatis sql exception", e);
        }
        List<Integer> idList = studentService.getStudentIdList();
        return ("" + idList.get(0) + idList.get(1));
    }

}
