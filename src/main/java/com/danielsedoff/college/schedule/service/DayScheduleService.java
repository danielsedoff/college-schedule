package com.danielsedoff.college.schedule.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

@Service
public class DayScheduleService {

    private DAO<DaySchedule> dayscheduledao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public DayScheduleService(DAO<DaySchedule> dayscheduledao, DAO<Lesson> lessondao) {
        this.dayscheduledao = dayscheduledao;
    }

    private static Logger logger = LoggerFactory.getLogger(DayScheduleService.class);

    public List<Integer> getDayscheduleIdList() {
        List<Integer> result = null;
        try {
            // DEBUG
            logger.info("DS Service entered");
            result = dayscheduledao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get Day Schedule ID List", e);
        }
        return result;
    }

    public boolean createDaySchedule(LocalDateTime date) {
        boolean hasOverlaps = false;
        DaySchedule ds = new DaySchedule();
        ds.setDay(date.format(formatter));
        ds.setHasOverlaps(hasOverlaps);
        boolean result = false;
        try {
            result = dayscheduledao.create(ds);
        } catch (DAOException e) {
            logger.error("Could not create a new Day Schedule with date", date);
        }
        return result;
    }

    public boolean updateDaySchedule(int dayschedId, LocalDateTime date, boolean hasOverlaps) {
        DaySchedule daysched = new DaySchedule();
        daysched.setDay(date.format(formatter));
        daysched.setHasOverlaps(hasOverlaps);
        boolean result = false;
        try {
            result = dayscheduledao.update(dayschedId, daysched);
        } catch (DAOException e) {
            logger.error("Could not Update a Day Schedule, id: {}", dayschedId);
        }
        return result;
    }

    public boolean deleteDayScheduleById(int dayschedId) {
        boolean result = false;
        try {
            result = dayscheduledao.delete(dayscheduledao.getById(dayschedId));
        } catch (DAOException e) {
            logger.error("Could not Delete Day Schedule by id: {}", dayschedId);
        }
        return result;
    }

    public DaySchedule getDayScheduleById(int dayschedId) {
        DaySchedule result = null;
        try {
            result = dayscheduledao.getById(dayschedId);
        } catch (DAOException e) {
            logger.error("Could not Get a Day Schedule by id: {}", dayschedId);
        }
        return result;
    }

}
