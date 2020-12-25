package com.danielsedoff.college.schedule.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    public String getStudentIds() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
        List<Integer> idList = studentService.getStudentIdList();
        return ("" + idList.get(0) + idList.get(1));
    }

}
