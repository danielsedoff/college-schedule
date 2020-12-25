package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    List<Integer> getStudentIdList()  {
        return professordao.getIdList();
    }

    boolean createStudent(Student student)
            {
        return studentdao.create(student);

    }

    boolean updateStudent(int studId, Student student)
            {
        return studentdao.update(studId, student);
    }

    boolean deleteStudent(int studId) {
        Student st = studentdao.getById(studId);
        return studentdao.delete(st);
    }

    Student getStudentById(int studentId)
            {
        return studentdao.getById(studentId);
    }

}
