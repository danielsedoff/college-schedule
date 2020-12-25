package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class CourseService {
    private CourseDAO coursedao;

    @Autowired
    public CourseService(CourseDAO coursedao) {
        this.coursedao = coursedao;
    }

    private static Logger logger = LoggerFactory.getLogger(CourseService.class);

    public List<Integer> getCourseIdList() {
        List<Integer> idlist = null;
        try {
            idlist = coursedao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get course ID list");
        }
        return idlist;
    }

    public boolean createCourse(Course course) {
        boolean result = false;
        try {
            result = coursedao.create(course);
        } catch (DAOException e) {
            logger.error("Could not create Course, id: {}", course.getId());
        }
        return result;
    }

    public Course getCourseById(int courseId) {
        Course result = null;
        try {
            result = coursedao.getById(courseId);
        } catch (DAOException e) {
            logger.error("Could not get Course by id: {}", courseId);
        }
        return result;
    }

    public boolean deleteCourseById(int courseId) {
        boolean result = false;
        try {
            result = coursedao.delete(coursedao.getById(courseId));
        } catch (DAOException e) {
            logger.error("Could not delete Course by id: {}", courseId);
        }
        return result;
    }

    public boolean updateCourse(int courseId, Course course) {
        boolean result = false;
        try {
            result = coursedao.update(courseId, course);
        } catch (DAOException e) {
            logger.error("Could not update Course, id: {}", courseId);
        }
        return result;
    }

    public boolean setCourseProfessors(int courseId, List<Professor> profs) {
        boolean result = false;
        try {
            result = coursedao.setCourseProfessor(coursedao.getById(courseId), profs);
        } catch (DAOException e) {
            logger.error("Could not set Professor-Course Relations, courseId: {}", courseId);
        }
        return result;
    }

    public List<Professor> getProfessorsByCourseById(int courseId) {
        List<Professor> result = null;
        try {
            Course course = coursedao.getById(courseId);
            result = coursedao.getProfessorByCourse(course);
        } catch (DAOException e) {
            logger.error("Could not get Professor-Course Relation, id: {}", courseId);
        }
        return result;
    }

}
