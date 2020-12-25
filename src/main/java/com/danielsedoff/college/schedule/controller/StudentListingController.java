package com.danielsedoff.college.schedule.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danielsedoff.college.schedule.config.AppConfig;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.SqlScriptRunner;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.service.StudentService;

@Controller

public class StudentListingController {

    @Autowired
    AppConfig appConfig = new AppConfig();
    @Autowired
    StudentDAO stdao = new StudentDAO(appConfig.jdbcTemplate());
    @Autowired
    ProfessorDAO professordao = new ProfessorDAO(appConfig.jdbcTemplate());
    @Autowired
    GroupDAO groupdao = new GroupDAO(appConfig.jdbcTemplate());

    @Autowired
    private SqlScriptRunner ibatisRead;
    private static final String SQL_FILE_NAME = "create_tables.sql";

    @GetMapping(value = "/students")
    @ResponseBody
    public String getStudentIds() throws IOException, SQLException {

        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);

        StudentService srv = new StudentService(professordao, stdao, groupdao);
        List<Integer> idList = srv.getStudentIdList();
        return ("" + idList.get(0) + idList.get(1));
    }

    public static void main(String[] args) {
        StudentListingController slc = new StudentListingController();
        try {
            System.out.println(slc.getStudentIds());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
