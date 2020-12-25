package com.danielsedoff.college.schedule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Service
public class YearScheduleService {
    private YearScheduleDAO yearscheduledao;
    private DayScheduleDAO dayscheduledao;

    @Autowired
    public YearScheduleService(YearScheduleDAO yearscheduledao,
            DayScheduleDAO dayscheduledao) {
        this.yearscheduledao = yearscheduledao;
        this.dayscheduledao = dayscheduledao;
    }

    private static Logger logger = LoggerFactory.getLogger(YearScheduleService.class);

    public List<Integer> getYearScheduleIdList() {
        List<Integer> result = null;
        try {
            result = yearscheduledao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get Year Schedule Id List", e);
        }
        return result;
    }

    public YearSchedule getYearScheduleById(int yearId) {
        YearSchedule result = null;
        try {
            result = yearscheduledao.getById(yearId);
        } catch (DAOException e) {
            logger.error("Could not get a Year Schedule By id: {}", yearId);
        }
        return result;
    }

    public boolean createYearSchedule(int year) {
        YearSchedule yearschedule = new YearSchedule();
        yearschedule.setYear(year);
        boolean result = false;
        try {
            result = yearscheduledao.create(yearschedule);
        } catch (DAOException e) {
            logger.error("Could not create a Year Schedule for year: {}", year);
        }
        return result;
    }

    public boolean deleteYearSchedule(int yearId) {
        boolean result = false;
        try {
            result = yearscheduledao.delete(yearscheduledao.getById(yearId));
        } catch (DAOException e) {
            logger.error("Could not delete a Year Schedule, id: {}", yearId);
        }
        return result;
    }

    public boolean updateYearSchedule(int yearId, int year) {
        boolean result = false;
        try {
            YearSchedule ys = yearscheduledao.getById(yearId);
            ys.setYear(year);
            result = yearscheduledao.update(year, ys);
        } catch (DAOException e) {
            logger.error("Could not update a Year Schedule, id: {}", yearId);
        }
        return result;
    }

    public boolean setDayScheduleYearSchedule(int daySchedId, int yearSchedId) {
        boolean result = false;
        try {
            YearSchedule yearschedule = yearscheduledao.getById(yearSchedId);
            DaySchedule dayschedule = dayscheduledao.getById(daySchedId);
            result = yearscheduledao.setDayScheduleYearSchedule(dayschedule,
                    yearschedule);
        } catch (DAOException e) {
            logger.error("Could not set a Day Schedule-Year Schedule Relation, year Id: {}", yearSchedId);
        }
        return result;
    }

    public List<DaySchedule> getDayScheduleByYearSchedule(int yearSchedId) {
        List<DaySchedule> result = null;
        try {
            YearSchedule yearschedule = yearscheduledao.getById(yearSchedId);
            result = yearscheduledao.getDayScheduleYearSchedule(yearschedule);
        } catch (DAOException e) {
            logger.error("Could not get Day Schedules List By Year Schedule, year Id: {}", yearSchedId);
        }
        return result;
    }

}
