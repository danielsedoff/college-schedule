package com.danielsedoff.college.schedule.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForLoopServlet", urlPatterns = { "/forloop" })
public class ForLoopServlet extends HttpServlet {

    private static final long serialVersionUID = 3837865670959058152L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
                String result = "";
                for(int i = 0; i < 100; i++){
                    result += i + System.lineSeparator();
                }

        ServletOutputStream out = resp.getOutputStream();
        out.write(result.getBytes());
        out.flush();
        out.close();
    }

}