package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    private static Logger logger = LoggerFactory.getLogger(CourseService.class);

    public boolean createCourse(Course course) {
        return courseRepo.save(course) != null;
    }

    public Course getCourseById(int courseId) {
        Optional<Course> result = courseRepo.findById(courseId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteCourseById(int courseId) {
        try {
            courseRepo.deleteById(courseId);
        } catch (Exception e) {
            logger.error("Could not delete Course by id: {}", courseId);
            return false;
        }
        return true;
    }

    public boolean updateCourse(int courseId, Course course) {
        try {
            Course managedCourse = courseRepo.findById(courseId).get();
            managedCourse.setCourseDescription(course.getCourseDescription());
            managedCourse.setName(course.getName());
            managedCourse.setProfessor(course.getProfessors());
            courseRepo.save(managedCourse);
        } catch (Exception e) {
            logger.error("Could not update Course, id: {}", courseId);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Course> getCourseList() {
        try {
            return (List<Course>) courseRepo.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Course List", e);
        }
        return null;
    }

}
