package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
class DayScheduleDAOTest {

    private JdbcTemplate jdbctemplate = new JdbcTemplate();
    private DayScheduleDAO dsdao = new DayScheduleDAO(this.jdbctemplate);
    private LessonDAO lessondao = new LessonDAO(this.jdbctemplate);
    
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
        assertEquals(now, dsdao.getById(5).getDay());
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
        List<Lesson> lessons = dsdao.getLessonsByDayschedule(lessondao, ds);
        Lesson requestedLesson = lessons.get(0);
        assertEquals(requestedLesson, originalLesson);
    }

    @Test
    void testGetLessonsByDayschedule() {
        DaySchedule ds = dsdao.getById(3);
        assertNotNull(dsdao.getLessonsByDayschedule(lessondao, ds));
    }

}
