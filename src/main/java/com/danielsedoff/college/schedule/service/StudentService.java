package com.danielsedoff.college.schedule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public boolean createStudent(Student student) {
        return studentRepo.save(student) != null;
    }

    public Student getStudentById(int studentId) {
        Optional<Student> result = studentRepo.findById(studentId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteStudentById(int studentId) {
        try {
            studentRepo.deleteById(studentId);
        } catch (Exception e) {
            logger.error("Could not delete Student by id: {}", studentId);
            return false;
        }
        return true;
    }

    public boolean updateStudent(int studentId, Student student) {
        try {
            Student managedStudent = studentRepo.findById(studentId).get();
            managedStudent.setGroup(student.getGroup());
            managedStudent.setName(student.getName());
            managedStudent.setSchoolYear(student.getSchoolYear());
            studentRepo.save(managedStudent);
        } catch (Exception e) {
            logger.error("Could not update Student, id: {}", studentId);
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        try {
            List<Student> students = new ArrayList<>();
            Iterable<Student> allStudents = studentRepo.findAll();
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
