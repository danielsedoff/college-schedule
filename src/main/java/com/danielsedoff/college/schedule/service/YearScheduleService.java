package com.danielsedoff.college.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    List<Integer> getYearScheduleIdList() {
        return yearscheduledao.getIdList();
    }

    YearSchedule getYearScheduleById(int yearId) {
        return yearscheduledao.getById(yearId);
    }

    boolean createYearSchedule(int year) {
        YearSchedule yearschedule = new YearSchedule();
        yearschedule.setYear(year);
        return yearscheduledao.create(yearschedule);
    }

    boolean deleteYearSchedule(int yearId) {
        return yearscheduledao.delete(yearscheduledao.getById(yearId));
    }

    boolean updateYearSchedule(int yearId, int year) {
        YearSchedule ys = yearscheduledao.getById(yearId);
        ys.setYear(year);
        return yearscheduledao.update(year, ys);
    }

    boolean setDayScheduleYearSchedule(int daySchedId, int yearSchedId) {
        YearSchedule yearschedule = yearscheduledao.getById(yearSchedId);
        DaySchedule dayschedule = dayscheduledao.getById(daySchedId);
        return yearscheduledao.setDayScheduleYearSchedule(dayschedule, yearschedule);
    }

    List<DaySchedule> getDayScheduleByYearSchedule(int yearSchedId) {
        YearSchedule yearschedule = yearscheduledao.getById(yearSchedId);
        return yearscheduledao.getDayScheduleYearSchedule(dayscheduledao, yearschedule);
    }

}
