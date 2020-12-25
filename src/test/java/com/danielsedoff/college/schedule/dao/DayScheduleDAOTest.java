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

import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

class DayScheduleDAOTest extends DAOTest {

    @Autowired
    private DayScheduleDAO dsdao;
    @Autowired
    private SqlScriptRunner ibatisRead;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() {
        List<Integer> result = dsdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() {
        int id = 1;
        DaySchedule ds = dsdao.getById(id);
        LocalDateTime today = LocalDateTime.now();
        ds.setDay(today);
        dsdao.update(id, ds);
        assertEquals(today, dsdao.getById(id).getDay());
    }

    @Test
    void testDelete() {
        int expectedResult = dsdao.getIdList().size() - 1;
        DaySchedule ds = new DaySchedule();
        ds.setId(1);
        dsdao.delete(ds);
        assertEquals(expectedResult, dsdao.getIdList().size());
    }

    @Test
    void testCreate() {
        int expectedSize = dsdao.getIdList().size() + 1;
        DaySchedule ds = new DaySchedule();
        LocalDateTime now = LocalDateTime.now();
        ds.setDay(now);
        dsdao.create(ds);
        assertEquals(expectedSize, dsdao.getIdList().size());
        assertEquals(now.format(formatter), dsdao.getById(5).getDay().format(formatter));
    }

    @Test
    void testGetById() {
        DaySchedule ds = dsdao.getById(1);
        assertNotNull(ds);
    }

    @Test
    void testSetLessonDayschedule() {
        LocalDateTime now = LocalDateTime.now();
        Lesson originalLesson = new Lesson();
        originalLesson.setStartTime(now);
        DaySchedule ds = dsdao.getById(3);
        dsdao.setLessonDayschedule(originalLesson, ds);
        List<Lesson> lessons = dsdao.getLessonsByDayschedule(ds);
        Lesson requestedLesson = lessons.get(0);
        assertEquals(requestedLesson, originalLesson);
    }

    @Test
    void testGetLessonsByDayschedule() {
        DaySchedule ds = dsdao.getById(3);
        assertNotNull(dsdao.getLessonsByDayschedule(ds));
    }

}
