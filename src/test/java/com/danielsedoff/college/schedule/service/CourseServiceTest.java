package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

class CourseServiceTest {

    CourseDAO coursedao = Mockito.mock(CourseDAO.class);
    ProfessorDAO profdao = Mockito.mock(ProfessorDAO.class);
    CourseService cservice = new CourseService(coursedao, profdao);

    @Test
    void testGetCourseIdList() throws DAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(coursedao.getIdList()).thenReturn(mockList);
        List<Integer> idList = cservice.getCourseIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateCourse() throws DAOException {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(coursedao.create(Mockito.any())).thenReturn(true);
        boolean successfulCreation = cservice.createCourse(course);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetCourseById() throws DAOException {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(coursedao.getById(Mockito.anyInt())).thenReturn(course);
        assertNotNull(cservice.getCourseById(1));
    }

    @Test
    void testDeleteCourseById() throws DAOException {
        Mockito.when(coursedao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = cservice.deleteCourseById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateCourse() throws DAOException {
        int courseId = 1;
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(coursedao.update(Mockito.anyInt(), Mockito.any())).thenReturn(true);
        boolean successfulUpdate = cservice.updateCourse(courseId, course);
        assertTrue(successfulUpdate);
    }

    @Test
    void testSetCourseProfessors() throws DAOException {
        List<Professor> profs = new ArrayList<>();
        int courseId = 1;
        Mockito.when(coursedao.setCourseProfessor(Mockito.any(), Mockito.any()))
                .thenReturn(true);
        assertTrue(cservice.setCourseProfessors(courseId, profs));
    }

    @Test
    void testGetProfessorsByCourseById() throws DAOException {
        int courseId = 1;
        List<Professor> profs = new ArrayList<>();
        profs.add(new Professor());
        Mockito.when(coursedao.getProfessorByCourse(Mockito.any())).thenReturn(profs);
        assertNotNull(cservice.getProfessorsByCourseById(courseId));
    }

}
