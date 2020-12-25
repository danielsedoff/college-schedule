package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

class YearScheduleServiceTest {

    YearScheduleService yservice = Mockito.mock(YearScheduleService.class);

    @Test
    void testGetYearScheduleIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(yservice.getYearScheduleIdList()).thenReturn(mockList);
        List<Integer> idList = yservice.getYearScheduleIdList();
        assertNotNull(idList);
    }

    @Test
    void testGetYearScheduleById() {
        YearSchedule ys = new YearSchedule();
        ys.setYear(1234);
        Mockito.when(yservice.getYearScheduleById(Mockito.anyInt())).thenReturn(ys);
        assertNotNull(yservice.getYearScheduleById(1));
    }

    @Test
    void testCreateYearSchedule() {
        Mockito.when(yservice.createYearSchedule(Mockito.anyInt())).thenReturn(true);
        boolean successfulCreation = yservice.createYearSchedule(1861);
        assertTrue(successfulCreation);
    }

    @Test
    void testDeleteYearSchedule() {
        Mockito.when(yservice.deleteYearSchedule(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = yservice.deleteYearSchedule(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateYearSchedule() {
        Mockito.when(yservice.updateYearSchedule(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        boolean successfulUpdate = yservice.updateYearSchedule(1, 1234);
        assertTrue(successfulUpdate);
    }

    @Test
    void testSetDayScheduleYearSchedule() {
        Mockito.when(yservice.setDayScheduleYearSchedule(Mockito.anyInt(), Mockito.anyInt())).thenReturn(true);
        boolean successfulSetDY = yservice.setDayScheduleYearSchedule(2, 2);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetDayScheduleByYearSchedule() {
        List<DaySchedule> mockList = new ArrayList<DaySchedule>();
        DaySchedule ds = new DaySchedule();
        mockList.add(ds);
        Mockito.when(yservice.getDayScheduleByYearSchedule(Mockito.anyInt())).thenReturn(mockList);
        List<DaySchedule> dayschedules = yservice.getDayScheduleByYearSchedule(1);
        assertNotNull(dayschedules);
    }

}
