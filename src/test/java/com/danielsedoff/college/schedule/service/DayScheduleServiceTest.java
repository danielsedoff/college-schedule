package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.danielsedoff.college.schedule.dao.DAOException.DayScheduleDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.LessonDAOException;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

class DayScheduleServiceTest {

    private DayScheduleDAO dsdao = Mockito.mock(DayScheduleDAO.class);
    private LessonDAO lessondao = Mockito.mock(LessonDAO.class);
    DayScheduleService dsservice = new DayScheduleService(dsdao, lessondao);

    @Test
    void testGetDayScheduleIdList() throws DayScheduleDAOException {
        List<Integer> mockList = new ArrayList<>();
        mockList.add(123);
        Mockito.when(dsdao.getIdList()).thenReturn(mockList);
        List<Integer> idList = dsservice.getDayscheduleIdList();
        assertNotNull(idList);
    }

    @Test
    void testCreateDaySchedule() throws DayScheduleDAOException {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsdao.create(Mockito.anyObject())).thenReturn(true);
        boolean successfulCreation = dsservice.createDaySchedule(today);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateDaySchedule() throws DayScheduleDAOException {
        LocalDateTime today = LocalDateTime.now();
        Mockito.when(dsdao.update(Mockito.any(), Mockito.any())).thenReturn(true);
        boolean successfulUpdate = dsservice.updateDaySchedule(1, today, false);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteDayScheduleById() throws DayScheduleDAOException {
        Mockito.when(dsdao.delete(Mockito.any())).thenReturn(true);
        boolean successfulDeletion = dsservice.deleteDayScheduleById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetDayScheduleById() throws DayScheduleDAOException {
        DaySchedule ds = new DaySchedule();
        ds.setDay(LocalDateTime.now());
        Mockito.when(dsdao.getById(Mockito.anyInt())).thenReturn(ds);
        assertNotNull(dsservice.getDayScheduleById(1));
    }

    @Test
    void testSetLessonDaySchedule() throws DayScheduleDAOException, LessonDAOException {
        Mockito.when(dsdao.setLessonDayschedule(Mockito.any(), Mockito.any()))
                .thenReturn(true);
        boolean successfulSetDY = dsservice.setLessonDaySchedule(2, 2);
        assertTrue(successfulSetDY);
    }

    @Test
    void testGetLessonsByDayScheduleById()
            throws DayScheduleDAOException, LessonDAOException {
        List<Lesson> mockList = new ArrayList<Lesson>();
        Lesson lesson = new Lesson();
        mockList.add(lesson);
        Mockito.when(dsdao.getLessonsByDayschedule(Mockito.any())).thenReturn(mockList);
        List<Lesson> lessons = dsservice.getLessonsByDayScheduleById(1);
        assertNotNull(lessons);
    }

}
