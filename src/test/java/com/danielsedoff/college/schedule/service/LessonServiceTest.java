package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException.GroupDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.LessonDAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;

class LessonServiceTest {

    ProfessorDAO profdao = Mockito.mock(ProfessorDAO.class);
    LessonDAO lessondao = Mockito.mock(LessonDAO.class);
    GroupDAO groupdao = Mockito.mock(GroupDAO.class);

    LessonService lservice = new LessonService(profdao, lessondao, groupdao);

    @Test
    void testGetGroupsByLessonId() throws LessonDAOException, GroupDAOException {

        List<Group> groups = lservice.getGroupsByLessonId(1);
        groups.add(new Group());
        Mockito.when(lessondao.getGroupsByLesson(Mockito.any())).thenReturn(groups);
        assertNotNull(lservice.getGroupsByLessonId(123));
    }

    @Test
    void testSetLessonGroup() throws LessonDAOException, GroupDAOException {
        Mockito.when(lessondao.setLessonGroup(Mockito.any(), Mockito.any()))
                .thenReturn(true);
        boolean successfulSetDY = lservice.setLessonGroup(2, 2);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetLessonById() throws LessonDAOException {
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lessondao.getById(Mockito.anyInt())).thenReturn(lesson);
        assertNotNull(lservice.getLessonById(1));
    }

    @Test
    void testCreateLesson() throws LessonDAOException {
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lessondao.create(lesson)).thenReturn(true);
        boolean successfulCreation = lservice.createLesson(lesson);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteLessonById() throws LessonDAOException {
        Mockito.when(lessondao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = lservice.deleteLessonById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateLesson() throws LessonDAOException {
        int lessonId = 1;
        Lesson lesson = new Lesson();
        lesson.setProfessor(new Professor());
        Mockito.when(lessondao.update(Mockito.anyInt(), Mockito.any())).thenReturn(true);
        boolean successfulUpdate = lservice.updateLesson(lessonId, lesson);
        assertTrue(successfulUpdate);
    }

    @Test
    void testGetLessonIdList() throws LessonDAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(lessondao.getIdList()).thenReturn(mockList);
        List<Integer> idList = lservice.getLessonIdList();
        assertNotNull(idList);
    }

}
