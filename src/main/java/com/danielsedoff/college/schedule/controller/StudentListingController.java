package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.service.StudentService;

public class StudentListingController {
    
    
    private static final String SEPARATOR = "; " + System.lineSeparator();
    private JdbcTemplate jdbcTemplate;
    @Autowired ProfessorDAO profdao = new ProfessorDAO(jdbcTemplate);
    @Autowired StudentDAO studentdao = new StudentDAO(jdbcTemplate);
    @Autowired GroupDAO groupdao = new GroupDAO(jdbcTemplate);

    @Autowired
    StudentService srv;

    public static void main(String[] args) {
        StudentListingController slc = new StudentListingController();
        System.out.println(slc.getStudentIds());
    }

    public String getStudentIds() {
        srv = new StudentService(profdao, studentdao, groupdao);
        List<Integer> ids = srv.getStudentIdList();
        StringBuilder message = new StringBuilder();
        for (int id : ids) {
            message.append(id).append(SEPARATOR);
        }
        return message.toString();
    }
}
