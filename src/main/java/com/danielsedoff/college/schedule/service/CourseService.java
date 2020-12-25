package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DAOException.CourseDAOException;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class CourseService {
    private CourseDAO coursedao;

    @Autowired
    public CourseService(CourseDAO coursedao, ProfessorDAO professordao) {
        this.coursedao = coursedao;
    }

    public List<Integer> getCourseIdList() throws CourseDAOException {
        return coursedao.getIdList();
    }

    public boolean createCourse(Course course) throws CourseDAOException {
        return coursedao.create(course);
    }

    public Course getCourseById(int courseId) throws CourseDAOException {
        return coursedao.getById(courseId);
    }

    public boolean deleteCourseById(int courseId) throws CourseDAOException {
        return coursedao.delete(coursedao.getById(courseId));
    }

    public boolean updateCourse(int courseId, Course course) throws CourseDAOException {
        return coursedao.update(courseId, course);
    }

    public boolean setCourseProfessors(int courseId, List<Professor> profs)
            throws CourseDAOException {
        return coursedao.setCourseProfessor(coursedao.getById(courseId), profs);
    }

    public List<Professor> getProfessorsByCourseById(int courseId)
            throws CourseDAOException {
        Course course = coursedao.getById(courseId);
        return coursedao.getProfessorByCourse(course);
    }

}
