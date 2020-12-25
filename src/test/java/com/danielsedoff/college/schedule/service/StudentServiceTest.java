package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.model.Student;
import com.danielsedoff.college.schedule.repositories.GroupRepository;
import com.danielsedoff.college.schedule.repositories.ProfessorRepository;
import com.danielsedoff.college.schedule.repositories.StudentRepository;

@SpringBootTest
class StudentServiceTest extends AbstractServiceTest {

    StudentRepository studentRepo = Mockito.mock(StudentRepository.class);
    ProfessorRepository profRepo = Mockito.mock(ProfessorRepository.class);
    GroupRepository groupRepo = Mockito.mock(GroupRepository.class);
    
    @Autowired
    StudentService stservice;

    @Autowired
    GroupService gservice;
    
    @Test
    void testCreateStudent() throws Exception {
        Student student = new Student();
        student.setName("John");
        student.setSchoolYear(2);
        student.setGroup(gservice.getGroupById(1));
        Mockito.when(studentRepo.save(Mockito.any())).thenReturn(true);
        boolean successfulCreation = stservice.createStudent(student);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetStudentById() throws Exception {
        Student student = new Student();
        student.setName("John");
        Mockito.when(studentRepo.findById((Mockito.anyInt()))).thenReturn(Optional.of(student));
        assertNotNull(stservice.getStudentById(1));
    }
    
    @Test
    void testDeleteStudent() throws Exception {
        boolean successfulDeletion = stservice.deleteStudentById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateStudent() throws Exception {
        int studId = 1;
        Student student = stservice.getStudentById(studId);
        student.setName("John");
        student.setGroup(gservice.getGroupById(1));
        student.setSchoolYear(2);
        boolean successfulUpdate = stservice.updateStudent(studId, student);
        assertTrue(successfulUpdate);
    }

}
