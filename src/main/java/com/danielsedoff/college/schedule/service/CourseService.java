package com.danielsedoff.college.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class CourseService {
    private CourseDAO coursedao;
    private ProfessorDAO professordao;

    @Autowired
    public CourseService(CourseDAO coursedao, ProfessorDAO professordao) {
        this.coursedao = coursedao;
        this.professordao = professordao;
    }

    public List<Integer> getCourseIdList() {
        return coursedao.getIdList();
    }

    public boolean createCourse(String courseName, String courseDescription) {
        Course course = new Course();
        course.setName(courseName);
        course.setCourseDescription(courseDescription);
        return coursedao.create(course);
    }

    public Course getCourseById(int courseId) {
        return coursedao.getById(courseId);
    }

    public boolean deleteCourseById(int courseId) {
        return coursedao.delete(coursedao.getById(courseId));
    }

    public boolean updateCourse(int courseId, Course course) {
        return coursedao.update(courseId, course);
    }

    public boolean setCourseProfessors(int courseId, List<Professor> profs) {
        return coursedao.setProfessorList(coursedao.getById(courseId), profs);
    }

    public List<Professor> getProfessorsByCourseById(int courseId) {
        Course course = coursedao.getById(courseId);
        return coursedao.getProfessorByCourse(professordao, course);
    }

}
