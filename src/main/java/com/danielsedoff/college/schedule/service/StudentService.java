package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class StudentService {

    private DAO<Student> studentdao;

    public StudentService(DAO<Student> studentdao) {
        super();
        this.studentdao = studentdao;
    }

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getStudentList() {
        List<Student> result = null;
        try {
            result = studentdao.getList();
        } catch (DAOException e) {
            logger.error("Could not get a Student List", e);
        }
        return result;
    }

    public List<Integer> getStudentIdList() {
        List<Integer> result = null;
        try {
            result = studentdao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get a Student Id List", e);
        }
        return result;
    }

    public boolean createStudent(Student student) {
        boolean result = false;
        try {
            result = studentdao.create(student);
        } catch (DAOException e) {
            logger.error("Could not create a Student", e);
        }
        return result;
    }

    public boolean updateStudent(int studId, Student student) {
        boolean result = false;
        try {
            result = studentdao.update(studId, student);
        } catch (DAOException e) {
            logger.error("Could not update a Student, id: {}", studId);
        }
        return result;
    }

    public boolean deleteStudent(int studId) {
        boolean result = false;
        try {
            Student st = studentdao.getById(studId);
            result = studentdao.delete(st);
        } catch (DAOException e) {
            logger.error("Could not delete a Student, id: {}", studId);
        }
        return result;
    }

    public Student getStudentById(int studentId) {
        Student result = null;
        try {
            result = studentdao.getById(studentId);
        } catch (DAOException e) {
            logger.error("Could not get a Student By id: {}", studentId);
        }
        return result;
    }

}
