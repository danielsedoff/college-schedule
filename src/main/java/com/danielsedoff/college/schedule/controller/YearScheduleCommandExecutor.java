package com.danielsedoff.college.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Service
public class YearScheduleCommandExecutor {
    private static final String WRONG_DAY_SCHEDULE_ID = "Wrong Day Schedule ID.";
    private static final String WRONG_YEAR_SCHEDULE_ID = "Wrong Year Schedule ID.";
    private static final String WRONG_YEAR = "Wrong Year.";
    private static final String WRONG_YEAR_ID = "Wrong Year ID.";
    private static final String FAILURE = "failure";
    private static final String SUCCESS = "success";
    private YearScheduleDAO yearscheduledao;
    private DayScheduleDAO dayscheduledao;

    @Autowired
    public YearScheduleCommandExecutor(YearScheduleDAO yearscheduledao,
            DayScheduleDAO dayscheduledao) {
        this.yearscheduledao = yearscheduledao;
        this.dayscheduledao = dayscheduledao;
    }

    public String getYearScheduleIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = yearscheduledao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String getYearScheduleById(String[] arguments) {
        String yearIdStr = arguments[0];
        int yearId = -1;
        try {
            yearId = Integer.parseInt(yearIdStr);
        } catch (Exception e) {
            return WRONG_YEAR_ID;
        }
        return yearscheduledao.getById(yearId).toString();
    }

    public String createYearSchedule(String[] arguments) {
        boolean result = false;
        String yearStr = arguments[0];
        int year = -1;
        try {
            year = Integer.parseInt(yearStr);
        } catch (Exception e) {
            return WRONG_YEAR;
        }
        YearSchedule yearschedule = new YearSchedule();
        yearschedule.setYear(year);
        result = yearscheduledao.create(yearschedule);
        return result ? SUCCESS : FAILURE;
    }

    public String deleteYearSchedule(String[] arguments) {
        boolean result = false;
        String yearIdStr = arguments[0];
        int yearId = -1;
        try {
            yearId = Integer.parseInt(yearIdStr);
        } catch (Exception e) {
            return WRONG_YEAR_ID;
        }
        result = yearscheduledao.delete(yearscheduledao.getById(yearId));
        return result ? SUCCESS : FAILURE;
    }

    public String updateYearSchedule(String[] arguments) {
        boolean result = false;
        String yearStr = arguments[0];
        String yearIdStr = arguments[1];
        int year = -1;
        int yearId = -1;
        try {
            year = Integer.parseInt(yearStr);
        } catch (Exception e) {
            return WRONG_YEAR;
        }
        try {
            yearId = Integer.parseInt(yearIdStr);
        } catch (Exception e) {
            return WRONG_YEAR_ID;
        }
        YearSchedule ys = yearscheduledao.getById(yearId);
        ys.setYear(year);
        result = yearscheduledao.update(year, ys);
        return result ? SUCCESS : FAILURE;
    }

    public String setDayScheduleYearSchedule(String[] arguments) {
        boolean result = false;
        String dayScheduleIdStr = arguments[0];
        String yearScheduleIdStr = arguments[1];
        int daySchedId = -1;
        int yearSchedId = -1;
        try {
            daySchedId = Integer.parseInt(dayScheduleIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        try {
            yearSchedId = Integer.parseInt(yearScheduleIdStr);
        } catch (Exception e) {
            return WRONG_YEAR_SCHEDULE_ID;
        }
        YearSchedule yearschedule = yearscheduledao.getById(yearSchedId);
        DaySchedule dayschedule = dayscheduledao.getById(daySchedId);
        result = yearscheduledao.setDayScheduleYearSchedule(dayschedule, yearschedule);
        return result ? SUCCESS : FAILURE;
    }

    public String getDayScheduleByYearSchedule(String[] arguments) {
        String yearSchedIdStr = arguments[0];
        int yearSchedId = -1;
        try {
            yearSchedId = Integer.parseInt(yearSchedIdStr);
        } catch (Exception e) {
            return WRONG_YEAR_SCHEDULE_ID;
        }
        YearSchedule yearschedule = null;
        try {
            yearschedule = yearscheduledao.getById(yearSchedId);
        } catch (Exception e) {
            return "Could not find year schedule.";
        }
        StringBuilder result = new StringBuilder();
        List<DaySchedule> dayschedules = yearscheduledao
                .getDayScheduleYearSchedule(dayscheduledao, yearschedule);
        for (DaySchedule dayschedule : dayschedules) {
            result.append(System.lineSeparator()).append(dayschedule.toString());
        }
        return result.toString();
    }

}
