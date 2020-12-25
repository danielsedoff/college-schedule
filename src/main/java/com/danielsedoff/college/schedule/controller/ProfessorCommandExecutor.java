package com.danielsedoff.college.schedule.controller;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;

@Component
public class ProfessorCommandExecutor {
    public CourseDAO coursedao;
    public LessonDAO lessondao;
    public ProfessorDAO professordao;
    public YearScheduleDAO yearscheduledao;
    public GroupDAO groupdao;
    public StudentDAO studentdao;
    public DayScheduleDAO dayscheduledao;
    public DateTimeFormatter formatter;

    String updateProfessor(String[] arguments) {
        // TODO Auto-generated method stub
        return null;
    }

    String createProfessor(String[] arguments) {
        // TODO Auto-generated method stub
        return null;
    }

    String deleteProfessor(String[] arguments) {
        // TODO Auto-generated method stub
        return null;
    }

    String getProfessorById(String[] arguments) {
        // TODO Auto-generated method stub
        return null;
    }

    String getProfessorIdList(String[] arguments) {
        // TODO Auto-generated method stub
        return null;
    }
}