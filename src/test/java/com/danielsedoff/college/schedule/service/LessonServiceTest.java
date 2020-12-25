package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;

class LessonServiceTest {

    LessonService lservice = Mockito.mock(LessonService.class);

    @Test
    void testGetGroupsByLessonId() {
        
        List<Group> groups = lservice.getGroupsByLessonId(1);
        groups.add(new Group());
        Mockito.when(lservice.getGroupsByLessonId(Mockito.anyInt())).thenReturn(groups);
        assertNotNull(lservice.getGroupsByLessonId(123));
    }

    @Test
    void testSetLessonGroup() {
        Mockito.when(lservice.setLessonGroup(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        boolean successfulSetDY = lservice.setLessonGroup(2, 2);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetLessonById() {
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lservice.getLessonById(Mockito.anyInt())).thenReturn(lesson);
        assertNotNull(lservice.getLessonById(1));
    }

    @Test
    void testCreateLesson() {
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lservice.createLesson(lesson)).thenReturn(true);
        boolean successfulCreation = lservice.createLesson(lesson);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteLessonById() {
        Mockito.when(lservice.deleteLessonById(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = lservice.deleteLessonById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateLesson() {
        int lessonId = 1;
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lservice.updateLesson(lessonId, lesson)).thenReturn(true);
        boolean successfulUpdate = lservice.updateLesson(lessonId, lesson);
        assertTrue(successfulUpdate);
    }

    @Test
    void testGetLessonIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(lservice.getLessonIdList()).thenReturn(mockList);
        List<Integer> idList = lservice.getLessonIdList();
        assertNotNull(idList);
    }

}
