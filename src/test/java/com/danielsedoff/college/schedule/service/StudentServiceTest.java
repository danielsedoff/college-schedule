package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.Student;

class StudentServiceTest {

    StudentService stservice = Mockito.mock(StudentService.class);

    @Test
    void testGetStudentIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(stservice.getStudentIdList()).thenReturn(mockList);
        List<Integer> idList = stservice.getStudentIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Jack");
        Mockito.when(stservice.createStudent(student)).thenReturn(true);
        boolean successfulCreation = stservice.createStudent(student);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateStudent() {
        int studId = 1;
        Student student = new Student();
        student.setName("John");
        Mockito.when(stservice.updateStudent(studId, student)).thenReturn(true);
        boolean successfulUpdate = stservice.updateStudent(studId, student);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteStudent() {
        Mockito.when(stservice.deleteStudent(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = stservice.deleteStudent(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setName("John");
        Mockito.when(stservice.getStudentById(Mockito.anyInt())).thenReturn(student);
        assertNotNull(stservice.getStudentById(1));
    }

}
