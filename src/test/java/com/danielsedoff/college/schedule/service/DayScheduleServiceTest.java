package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.dao.DayScheduleRepository;
import com.danielsedoff.college.schedule.model.DaySchedule;
@SpringBootTest
class DayScheduleServiceTest extends AbstractServiceTest {

    DayScheduleRepository dsdao = Mockito.mock(DayScheduleRepository.class);

    @Autowired
    DayScheduleService dsservice = new DayScheduleService();

    @Test
    void testCreateDaySchedule() throws Exception {
        DaySchedule ds = new DaySchedule();
        ds.setDay("2000-10-10");
        boolean successfulCreation = dsservice.createDaySchedule(ds);
        assertTrue(successfulCreation);
    }

    @Test
    void testUpdateDaySchedule() throws Exception {
        LocalDateTime today = LocalDateTime.now();
        boolean successfulUpdate = dsservice.updateDaySchedule(1, today, false);
        assertTrue(successfulUpdate);
    }

    @Test
    void testDeleteDayScheduleById() throws Exception {
        dsdao.delete(Mockito.any());
        boolean successfulDeletion = dsservice.deleteDayScheduleById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testGetDayScheduleById() throws Exception {
        DaySchedule ds = new DaySchedule();
        ds.setDay("2000-10-10");
        Mockito.when(dsdao.findById(Mockito.anyInt())).thenReturn(Optional.of(ds));
        assertNotNull(dsservice.getDayScheduleById(1));
    }

}
