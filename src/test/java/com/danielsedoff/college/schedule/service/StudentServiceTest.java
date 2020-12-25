package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Student;

class StudentServiceTest {

    StudentDAO studentdao = Mockito.mock(StudentDAO.class);
    ProfessorDAO profdao = Mockito.mock(ProfessorDAO.class);
    GroupDAO groupdao = Mockito.mock(GroupDAO.class);
    StudentService stservice = new StudentService( studentdao);

    @Test
    void testGetStudentIdList() throws DAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(studentdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = stservice.getStudentIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateStudent() throws DAOException {
        Student student = new Student();
        student.setName("John");
        student.setGroup(groupdao.getById(1));
        student.setSchoolYear(2);
        Mockito.when(studentdao.create(student)).thenReturn(true);
        boolean successfulCreation = stservice.createStudent(student);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateStudent() throws DAOException {
        int studId = 1;
        Student student = new Student();
        student.setName("John");
        student.setGroup(groupdao.getById(1));
        student.setSchoolYear(2);
        Mockito.when(studentdao.update(studId, student)).thenReturn(true);
        boolean successfulUpdate = stservice.updateStudent(studId, student);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteStudent() throws DAOException {
        Student student = new Student();
        student.setId(1);
        Mockito.when(studentdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = stservice.deleteStudent(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetStudentById() throws DAOException {
        Student student = new Student();
        student.setName("John");
        Mockito.when(studentdao.getById((Mockito.anyInt()))).thenReturn(student);
        assertNotNull(stservice.getStudentById(1));
    }

}
