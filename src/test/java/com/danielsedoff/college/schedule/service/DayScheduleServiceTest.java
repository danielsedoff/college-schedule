package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

class DayScheduleServiceTest {

    DayScheduleService dsservice = Mockito.mock(DayScheduleService.class);

    @Test
    void testGetDayScheduleIdList() {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(dsservice.getDayscheduleIdList()).thenReturn(mockList);
        List<Integer> idList = dsservice.getDayscheduleIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateDaySchedule() {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsservice.createDaySchedule(Mockito.anyObject())).thenReturn(true);
        boolean successfulCreation = dsservice.createDaySchedule(today);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateDaySchedule() {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsservice.updateDaySchedule(1, today, false)).thenReturn(true);
        boolean successfulUpdate = dsservice.updateDaySchedule(1, today, false);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteDayScheduleById() {
        Mockito.when(dsservice.deleteDayScheduleById(Mockito.anyInt())).thenReturn(true);
        boolean successfulDeletion = dsservice.deleteDayScheduleById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetDayScheduleById() {
        DaySchedule ds = new DaySchedule();
        ds.setDay(LocalDateTime.now());
        Mockito.when(dsservice.getDayScheduleById(Mockito.anyInt())).thenReturn(ds);
        assertNotNull(dsservice.getDayScheduleById(1));
    }

    @Test
    void testSetLessonDaySchedule() {
        Mockito.when(dsservice.setLessonDaySchedule(Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(true);
        boolean successfulSetDY = dsservice.setLessonDaySchedule(2, 2);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetLessonsByDayScheduleById() {
        List<Lesson> mockList = new ArrayList<Lesson>();
        Lesson lesson = new Lesson();
        mockList.add(lesson);
        Mockito.when(dsservice.getLessonsByDayScheduleById(Mockito.anyInt()))
                .thenReturn(mockList);
        List<Lesson> lessons = dsservice.getLessonsByDayScheduleById(1);
        assertNotNull(lessons);
    }

}
