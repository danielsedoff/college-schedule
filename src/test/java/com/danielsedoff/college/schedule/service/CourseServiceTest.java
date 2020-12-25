package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

class CourseServiceTest {

    CourseService cservice = Mockito.mock(CourseService.class);

    @Test
    void testGetCourseIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(cservice.getCourseIdList()).thenReturn(mockList);
        List<Integer> idList = cservice.getCourseIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateCourse() {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(cservice.createCourse(course)).thenReturn(true);
        boolean successfulCreation = cservice.createCourse(course);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetCourseById() {
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(cservice.getCourseById(Mockito.anyInt())).thenReturn(course);
        assertNotNull(cservice.getCourseById(1));
    }

    @Test
    void testDeleteCourseById() {
        Mockito.when(cservice.deleteCourseById(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = cservice.deleteCourseById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateCourse() {
        int courseId = 1;
        Course course = new Course();
        course.setName("Wine Studies");
        Mockito.when(cservice.updateCourse(courseId, course)).thenReturn(true);
        boolean successfulUpdate = cservice.updateCourse(courseId, course);
        assertTrue(successfulUpdate);
    }

    @Test
    void testSetCourseProfessors() {
        List<Professor> profs = new ArrayList<>();
        int courseId = 1;
        Mockito.when(cservice.setCourseProfessors(courseId, profs)).thenReturn(true);
        assertTrue(cservice.setCourseProfessors(courseId, profs));
    }

    @Test
    void testGetProfessorsByCourseById() {
        int courseId = 1;
        List<Professor> profs = new ArrayList<>();
        profs.add(new Professor());
        Mockito.when(cservice.getProfessorsByCourseById(courseId)).thenReturn(profs);
        assertNotNull(cservice.getProfessorsByCourseById(courseId));
    }

}
