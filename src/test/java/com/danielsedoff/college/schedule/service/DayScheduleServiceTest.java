package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.model.DaySchedule;

class DayScheduleServiceTest {

    private DayScheduleDAO dsdao = Mockito.mock(DayScheduleDAO.class);
    private LessonDAO lessondao = Mockito.mock(LessonDAO.class);
    DayScheduleService dsservice = new DayScheduleService(dsdao, lessondao);

    @Test
    void testGetDayScheduleIdList() throws DAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(dsdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = dsservice.getDayscheduleIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateDaySchedule() throws DAOException {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsdao.create(Mockito.anyObject())).thenReturn(true);
        boolean successfulCreation = dsservice.createDaySchedule(today);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateDaySchedule() throws DAOException {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsdao.update(Mockito.any(), Mockito.any())).thenReturn(true);
        boolean successfulUpdate = dsservice.updateDaySchedule(1, today, false);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteDayScheduleById() throws DAOException {
        Mockito.when(dsdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = dsservice.deleteDayScheduleById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetDayScheduleById() throws DAOException {
        DaySchedule ds = new DaySchedule();
        ds.setDay("2000-10-10");
        Mockito.when(dsdao.getById(Mockito.anyInt())).thenReturn(ds);
        assertNotNull(dsservice.getDayScheduleById(1));
    }

}
