package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class StudentService {

    private StudentDAO studentdao;
    private ProfessorDAO professordao;

    @Autowired
    public StudentService(ProfessorDAO professordao, StudentDAO studentdao,
            GroupDAO groupdao) {
        this.professordao = professordao;
        this.studentdao = studentdao;
    }

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    List<Integer> getStudentIdList() {
        List<Integer> result = null;
        try {
            result = professordao.getIdList();
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean createStudent(Student student) {
        boolean result = false;
        try {
            result = studentdao.create(student);

        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean updateStudent(int studId, Student student) {
        boolean result = false;
        try {
            result = studentdao.update(studId, student);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean deleteStudent(int studId) {
        boolean result = false;
        try {
            Student st = studentdao.getById(studId);
            result = studentdao.delete(st);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public Student getStudentById(int studentId) {
        Student result = null;
        try {
            result = studentdao.getById(studentId);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

}
