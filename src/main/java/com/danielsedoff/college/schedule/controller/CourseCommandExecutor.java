package com.danielsedoff.college.schedule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class CourseCommandExecutor {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String WRONG_COURSE_ID = "Wrong Course ID.";
    private CourseDAO coursedao;
    private ProfessorDAO professordao;

    @Autowired
    public CourseCommandExecutor(CourseDAO coursedao, ProfessorDAO professordao) {
        this.coursedao = coursedao;
        this.professordao = professordao;
    }

    public String getCourseIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = coursedao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String createCourse(String[] arguments) {
        boolean result = false;
        String courseName = arguments[0];
        String courseDescription = arguments[1];
        Course course = new Course();
        course.setName(courseName);
        course.setCourseDescription(courseDescription);
        result = coursedao.create(course);
        return result ? SUCCESS : FAILURE;
    }

    public String getCourseById(String[] arguments) {
        String courseIdStr = arguments[0];
        int courseId = -1;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (Exception e) {
            return WRONG_COURSE_ID;
        }
        return coursedao.getById(courseId).toString();
    }

    public String deleteCourse(String[] arguments) {
        boolean result = false;
        String courseIdStr = arguments[0];
        int courseId = -1;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (Exception e) {
            return WRONG_COURSE_ID;
        }
        result = coursedao.delete(coursedao.getById(courseId));
        return result ? SUCCESS : FAILURE;
    }

    public String updateCourse(String[] arguments) {
        String courseName = arguments[0];
        String courseDescription = arguments[1];
        String courseIdStr = arguments[2];
        int courseId = -1;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (Exception e) {
            return WRONG_COURSE_ID;
        }
        Course course = new Course();
        course.setName(courseName);
        course.setCourseDescription(courseDescription);
        boolean result = coursedao.update(courseId, course);
        return result ? SUCCESS : FAILURE;
    }

    public String setCourseProfessors(String[] arguments) {
        String courseIdStr = arguments[0];
        int courseId = -1;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (Exception e) {
            return WRONG_COURSE_ID;
        }
        String professorIdStr = arguments[1];
        int professorId = -1;
        try {
            professorId = Integer.parseInt(professorIdStr);
        } catch (Exception e) {
            return "Wrong Professor ID.";
        }
        boolean result = false;
        List<Professor> profs = new ArrayList<>();
        profs.add(professordao.getById(professorId));
        result = coursedao.setProfessorList(coursedao.getById(courseId), profs);
        return result ? SUCCESS : FAILURE;
    }

    public String getProfessorsByCourse(String[] arguments) {
        String courseIdStr = arguments[0];
        int courseId = -1;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (Exception e) {
            return WRONG_COURSE_ID;
        }
        Course course = null;
        try {
            course = coursedao.getById(courseId);
        } catch (Exception e) {
            return "Could not find course";
        }
        StringBuilder result = new StringBuilder();
        List<Professor> profs = coursedao.getProfessorByCourse(professordao, course);
        for (Professor prof : profs) {
            result.append(System.lineSeparator()).append(prof.toString());
        }
        return result.toString();
    }

}
