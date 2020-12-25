package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Component
class YearScheduleDAOTest {

    private JdbcTemplate jdbctemplate = new JdbcTemplate();
    private YearScheduleDAO yeardao = new YearScheduleDAO(this.jdbctemplate);
    private DayScheduleDAO dsdao = new DayScheduleDAO(this.jdbctemplate);

    @Test
    void testGetIdList() {
        List<Integer> result = yeardao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() {
        int id = 1;
        int hundredYearWarBeginning = 1337;
        YearSchedule ys = yeardao.getById(id);
        ys.setYear(hundredYearWarBeginning);
        yeardao.update(id, ys);
        assertEquals(hundredYearWarBeginning, yeardao.getById(id).getYear());
    }

    @Test
    void testDelete() {
        int expectedResult = yeardao.getIdList().size() - 1;
        YearSchedule ys = new YearSchedule();
        int unixStartYear = 1970;
        ys.setYear(unixStartYear);
        yeardao.delete(ys);
        assertEquals(expectedResult, yeardao.getIdList().size());
    }

    @Test
    void testCreate() {
        int expectedSize = yeardao.getIdList().size() + 1;
        YearSchedule ys = new YearSchedule();
        int hundredYearWarBeginning = 1337;
        ys.setYear(hundredYearWarBeginning);
        yeardao.create(ys);
        assertEquals(expectedSize, yeardao.getIdList().size());
        assertEquals(hundredYearWarBeginning, yeardao.getById(5).getYear());
    }

    @Test
    void testGetById() {
        YearSchedule ys = yeardao.getById(1);
        assertNotNull(ys);
    }

    @Test
    void testSetDayScheduleYearSchedule() {
        YearSchedule ys = yeardao.getById(1);
        DaySchedule ds = new DaySchedule();
        ds.setDay(LocalDateTime.now());
        List<DaySchedule> pushed = new ArrayList<>();
        pushed.add(ds);
        yeardao.setDayScheduleYearSchedule(ds, ys);
        List<DaySchedule> requested = yeardao.getDayScheduleYearSchedule(dsdao, ys);
        assertEquals(requested, pushed);
    }

    @Test
    void testGetDayScheduleYearSchedule() {
        YearSchedule ys = yeardao.getById(1);
        List<DaySchedule> requested = yeardao.getDayScheduleYearSchedule(dsdao, ys);
        assertNotNull(requested);
    }

}