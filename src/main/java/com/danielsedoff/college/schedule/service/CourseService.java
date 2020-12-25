package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.Course;

@Service
public class CourseService {

    private DAO<Course> coursedao;

    public CourseService(DAO<Course> coursedao) {
        this.coursedao = coursedao;
    }

    private static Logger logger = LoggerFactory.getLogger(CourseService.class);

    public List<Integer> getCourseIdList() {
        try {
            return coursedao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get course ID list");
        }
        return null;
    }

    public boolean createCourse(Course course) {
        try {
            return coursedao.create(course);
        } catch (DAOException e) {
            logger.error("Could not create Course, id: {}", course.getId());
        }
        return false;
    }

    public Course getCourseById(int courseId) {
        try {
            return coursedao.getById(courseId);
        } catch (DAOException e) {
            logger.error("Could not get Course by id: {}", courseId);
        }
        return null;
    }

    public boolean deleteCourseById(int courseId) {
        try {
            return coursedao.delete(coursedao.getById(courseId));
        } catch (DAOException e) {
            logger.error("Could not delete Course by id: {}", courseId);
        }
        return false;
    }

    public boolean updateCourse(int courseId, Course course) {
        try {
            return coursedao.update(courseId, course);
        } catch (DAOException e) {
            logger.error("Could not update Course, id: {}", courseId);
        }
        return false;
    }

    public List<Course> getCourseList() {
        try {
            return coursedao.getList();
        } catch (DAOException e) {
            logger.error("Could not get a Course List", e);
        }
        return null;
    }

}
