package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.dao.DAOException.GroupDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.LessonDAOException;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;

class LessonDAOTest extends DAOTest {

    @Autowired
    private LessonDAO lessondao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws LessonDAOException {
        List<Integer> result = lessondao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws LessonDAOException {
        int id = 1;
        Lesson lesson = lessondao.getById(id);
        LocalDateTime today = LocalDateTime.now();
        lesson.setStartTime(today);
        lessondao.update(id, lesson);
        assertEquals(today, lessondao.getById(id).getStartTime());
    }

    @Test
    void testDelete() throws LessonDAOException {
        int expectedResult = lessondao.getIdList().size() - 1;
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lessondao.delete(lesson);
        assertEquals(expectedResult, lessondao.getIdList().size());
    }

    @Test
    void testCreate() throws LessonDAOException {
        int expectedSize = lessondao.getIdList().size() + 1;
        Lesson lesson = new Lesson();
        LocalDateTime now = LocalDateTime.now();
        lesson.setStartTime(now);
        lessondao.create(lesson);
        assertEquals(expectedSize, lessondao.getIdList().size());
        assertEquals(now, lessondao.getById(5).getStartTime());
    }

    @Test
    void testGetById() throws LessonDAOException {
        Lesson lesson = lessondao.getById(1);
        assertNotNull(lesson);
    }

    @Test
    void testSetLessonGroup() throws LessonDAOException, GroupDAOException {
        Lesson lesson = lessondao.getById(3);
        Group group = new Group();
        String note = "Some New Group";
        List<String> noteList = new ArrayList<>();
        noteList.add(note);
        group.setSpecialNotes(noteList);
        lessondao.setLessonGroup(lesson, group);
        assertEquals(noteList, lessondao.getGroupsByLesson(lesson));
    }

    @Test
    void testGetGroupsByLesson() throws LessonDAOException, GroupDAOException {
        Lesson lesson = lessondao.getById(3);
        assertNotNull(lessondao.getGroupsByLesson(lesson));
    }

}
