package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;

class LessonDAOTest extends DAOTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    private LessonDAO lessondao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = lessondao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        LocalDateTime now = LocalDateTime.now();
        Lesson lesson = lessondao.getById(id);
        lesson.setStartTime(now);
        lesson.setEndTime(now);
        lesson.setStartTime(now);
        Professor prof = new Professor();
        prof.setName("John Deere");
        lesson.setProfessor(prof);
        lessondao.update(id, lesson);
        assertEquals(now.format(formatter),
                lessondao.getById(id).getStartTime().format(formatter));

    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = lessondao.getIdList().size() - 1;
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lessondao.delete(lesson);
        assertEquals(expectedResult, lessondao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = lessondao.getIdList().size() + 1;
        Lesson lesson = new Lesson();
        LocalDateTime now = LocalDateTime.now();
        lesson.setStartTime(now);
        lesson.setEndTime(now);
        Professor prof = new Professor();
        prof.setName("John Deere");
        lesson.setProfessor(prof);
        lessondao.create(lesson);
        assertEquals(expectedSize, lessondao.getIdList().size());
        assertEquals(now.format(formatter),
                lessondao.getById(5).getStartTime().format(formatter));
    }

    @Test
    void testGetById() throws DAOException {
        Lesson lesson = lessondao.getById(1);
        assertNotNull(lesson);
    }

    @Test
    void testSetLessonGroup() throws DAOException {
        Lesson lesson = lessondao.getById(3);
        Group group = new Group();
        int originalId = 3;
        group.setId(originalId);
        lessondao.setLessonGroup(lesson, group);
        List<Group> returnedList = lessondao.getGroupsByLesson(lesson);
        int lastGroupId = returnedList.get(returnedList.size() - 1).getId();
        assertEquals(lastGroupId, originalId);
    }

    @Test
    void testGetGroupsByLesson() throws DAOException {
        Lesson lesson = lessondao.getById(3);
        assertNotNull(lessondao.getGroupsByLesson(lesson));
    }

}
