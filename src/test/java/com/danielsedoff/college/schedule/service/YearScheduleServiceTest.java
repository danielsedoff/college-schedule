package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;
import com.danielsedoff.college.schedule.model.YearSchedule;

class YearScheduleServiceTest {

    DayScheduleDAO dsdao = Mockito.mock(DayScheduleDAO.class);
    YearScheduleDAO ysdao = Mockito.mock(YearScheduleDAO.class);
    YearScheduleService yservice = new YearScheduleService(ysdao, dsdao);

    @Test
    void testGetYearScheduleIdList() throws DAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(ysdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = yservice.getYearScheduleIdList();
        assertNotNull(idList);
    }

    @Test
    void testGetYearScheduleById() throws DAOException {
        YearSchedule ys = new YearSchedule();
        ys.setYear(1234);
        Mockito.when(ysdao.getById(Mockito.anyInt())).thenReturn(ys);
        assertNotNull(yservice.getYearScheduleById(1));
    }

    @Test
    void testCreateYearSchedule() throws DAOException {
        Mockito.when(ysdao.create(Mockito.any())).thenReturn(true);
        boolean successfulCreation = yservice.createYearSchedule(1861);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteYearSchedule() throws DAOException {
        Mockito.when(ysdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = yservice.deleteYearSchedule(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateYearSchedule() throws DAOException {
        Mockito.when(ysdao.update(Mockito.any(), Mockito.any())).thenReturn(true);
        Mockito.when(ysdao.getById(Mockito.anyInt())).thenReturn(new YearSchedule());
        boolean successfulUpdate = yservice.updateYearSchedule(1, 1234);
        assertTrue(successfulUpdate);
    }

}
