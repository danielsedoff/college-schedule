package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.model.Student;

class StudentServiceTest {

    StudentDAO stdao = Mockito.mock(StudentDAO.class);
    ProfessorDAO professordao = Mockito.mock(ProfessorDAO.class);
    GroupDAO groupdao = Mockito.mock(GroupDAO.class);
    StudentService stservice = new StudentService(professordao, stdao, groupdao);

    @Test
    void testGetStudentIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(stdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = stservice.getStudentIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Jack");
        Mockito.when(stdao.create(student)).thenReturn(true);
        boolean successfulCreation = stservice.createStudent(student);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateStudent() {
        int studId = 1;
        Student student = new Student();
        student.setName("John");
        Mockito.when(stdao.update(studId, student)).thenReturn(true);
        boolean successfulUpdate = stservice.updateStudent(studId, student);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteStudent() {
        Student student = new Student();
        student.setId(1);
        Mockito.when(stdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = stservice.deleteStudent(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setName("John");
        Mockito.when(stdao.getById((Mockito.anyInt()))).thenReturn(student);
        assertNotNull(stservice.getStudentById(1));
    }

}
