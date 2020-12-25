package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

class YearScheduleDAOTest extends DAOTest {

    @Autowired
    private YearScheduleDAO yeardao;
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = yeardao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        int hundredYearWarBeginning = 1337;
        YearSchedule ys = yeardao.getById(id);
        ys.setYear(hundredYearWarBeginning);
        yeardao.update(id, ys);
        assertEquals(hundredYearWarBeginning, yeardao.getById(id).getYear());
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = yeardao.getIdList().size() - 1;
        YearSchedule ys = new YearSchedule();
        ys.setId(1);
        yeardao.delete(ys);
        assertEquals(expectedResult, yeardao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = yeardao.getIdList().size() + 1;
        YearSchedule ys = new YearSchedule();
        int hundredYearWarBeginning = 1337;
        ys.setYear(hundredYearWarBeginning);
        yeardao.create(ys);
        assertEquals(expectedSize, yeardao.getIdList().size());
        assertEquals(hundredYearWarBeginning, yeardao.getById(5).getYear());
    }

    @Test
    void testGetById() throws DAOException {
        YearSchedule ys = yeardao.getById(1);
        assertNotNull(ys);
    }

    @Test
    void testSetDayScheduleYearSchedule() throws DAOException {
        YearSchedule ys = yeardao.getById(1);
        DaySchedule ds = new DaySchedule();
        ds.setDay(LocalDateTime.now());
        ds.setId(2);
        yeardao.setDayScheduleYearSchedule(ds, ys);
        List<DaySchedule> requested = yeardao.getDayScheduleYearSchedule(ys);
        assertEquals(2, requested.get(0).getId());
    }

    @Test
    void testGetDayScheduleYearSchedule() throws DAOException {
        YearSchedule ys = yeardao.getById(1);
        List<DaySchedule> requested = yeardao.getDayScheduleYearSchedule(ys);
        assertNotNull(requested);
    }

}