package com.danielsedoff.college.schedule.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danielsedoff.college.schedule.controller.StudentListingController;
import com.danielsedoff.college.schedule.service.ProfessorService;

@WebServlet(name = "StudentStatus", urlPatterns = { "/students" })
public class StudentStatus extends HttpServlet {

    private static final long serialVersionUID = -6196575704508139464L;
    private static Logger logger = LoggerFactory.getLogger(ProfessorService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();

        StudentListingController studentListingController = new StudentListingController();
        String userMessageString;
        try {
            userMessageString = studentListingController.getStudentIds();
            out.write(userMessageString.getBytes());
        } catch (IOException e) {
            logger.error("Filesystem error: ", e);
        } catch (SQLException e) {
            logger.error("SQL error: ", e);
        }

        out.flush();
        out.close();
    }

}