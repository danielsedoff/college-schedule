package com.danielsedoff.college.schedule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.StudentRepository;
import com.danielsedoff.college.schedule.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentdao;

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public boolean createStudent(Student student) {
        return studentdao.save(student) != null;
    }

    public Student getStudentById(int studentId) {
        Optional<Student> result = studentdao.findById(studentId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteStudentById(int studentId) {
        try {
            studentdao.deleteById(studentId);
        } catch (Exception e) {
            logger.error("Could not delete Student by id: {}", studentId);
            return false;
        }
        return true;
    }

    public boolean updateStudent(int studentId, Student student) {
        try {
            Student managedStudent = studentdao.findById(studentId).get();
            managedStudent.setGroup(student.getGroup());
            managedStudent.setName(student.getName());
            managedStudent.setSchoolYear(student.getSchoolYear());
            studentdao.save(managedStudent);
        } catch (Exception e) {
            logger.error("Could not update Student, id: {}", studentId);
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        try {
            List<Student> students = new ArrayList<>();
            Iterable<Student> allStudents = studentdao.findAll();
            allStudents.forEach(stud -> {
                students.add(stud);
            });
            return students;
        } catch (Exception e) {
            logger.error("Could not get a Student List", e);
        }
        return null;
    }

}
