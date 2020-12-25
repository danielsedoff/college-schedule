package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.model.DaySchedule;

class DayScheduleDAOTest extends DAOTest {

    @Autowired
    private DAO<DaySchedule> dsdao;
    
    @Autowired
    private SqlScriptRunner ibatisRead;

    @BeforeEach
    final void readSQLfile() throws IOException, SQLException {
        ibatisRead.readSQLFileWithIbatis(SQL_FILE_NAME);
    }

    @Test
    void testGetIdList() throws DAOException {
        List<Integer> result = dsdao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() throws DAOException {
        int id = 1;
        DaySchedule ds = dsdao.getById(id);
        ds.setDay("2000-10-10");
        dsdao.update(id, ds);
        assertEquals("2000-10-10", dsdao.getById(id).getDay());
    }

    @Test
    void testDelete() throws DAOException {
        int expectedResult = dsdao.getIdList().size() - 1;
        DaySchedule ds = dsdao.getById(2);
        dsdao.delete(ds);
        assertEquals(expectedResult, dsdao.getIdList().size());
    }

    @Test
    void testCreate() throws DAOException {
        int expectedSize = dsdao.getIdList().size() + 1;
        DaySchedule ds = new DaySchedule();
        ds.setDay("2000-10-10");
        dsdao.create(ds);
        assertEquals(expectedSize, dsdao.getIdList().size());
        assertEquals("2000-10-10", dsdao.getById(5).getDay());
    }

    @Test
    void testGetById() throws DAOException {
        DaySchedule ds = dsdao.getById(1);
        assertNotNull(ds);
    }

}
