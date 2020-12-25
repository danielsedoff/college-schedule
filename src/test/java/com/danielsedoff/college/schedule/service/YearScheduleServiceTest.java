package com.danielsedoff.college.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielsedoff.college.schedule.model.YearSchedule;
import com.danielsedoff.college.schedule.repositories.DayScheduleRepository;
import com.danielsedoff.college.schedule.repositories.YearScheduleRepository;

@SpringBootTest
class YearScheduleServiceTest extends AbstractServiceTest {

    DayScheduleRepository dsRepo = Mockito.mock(DayScheduleRepository.class);
    YearScheduleRepository ysRepo = Mockito.mock(YearScheduleRepository.class);

    @Autowired
    YearScheduleService yservice = new YearScheduleService();

    @Test
    void testCreateYearSchedule() throws Exception {
        Mockito.when(ysRepo.save(Mockito.any())).thenReturn(true);
        YearSchedule ys = new YearSchedule();
        ys.setYear(1234);
        boolean successfulCreation = yservice.createYearSchedule(ys);
        assertTrue(successfulCreation);
    }

    @Test
    void testGetYearScheduleById() throws Exception {
        YearSchedule ys = new YearSchedule();
        ys.setYear(1234);
        Mockito.when(ysRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(ys));
        assertNotNull(yservice.getYearScheduleById(1));
    }
    
    @Test
    void testDeleteYearSchedule() throws Exception {
        ysRepo.delete(Mockito.any());
        boolean successfulDeletion = yservice.deleteYearScheduleById(1);
        assertTrue(successfulDeletion);
    }

    @Test
    void testUpdateYearSchedule() throws Exception {
        int y = 1234;
        YearSchedule ys = new YearSchedule();
        ys.setYear(y);
        boolean successfulUpdate = yservice.updateYearSchedule(1, ys);
        assertTrue(successfulUpdate);
    }

}
