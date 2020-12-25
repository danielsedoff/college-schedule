package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.YearScheduleRepository;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Service
public class YearScheduleService {

    @Autowired
    private YearScheduleRepository yearscheduledao;

    private static Logger logger = LoggerFactory.getLogger(YearScheduleService.class);

    public boolean createYearSchedule(YearSchedule yearschedule) {
        return yearscheduledao.save(yearschedule) != null;
    }

    public YearSchedule getYearScheduleById(int yearscheduleId) {
        Optional<YearSchedule> result = yearscheduledao.findById(yearscheduleId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteYearScheduleById(int yearscheduleId) {
        try {
            yearscheduledao.deleteById(yearscheduleId);
        } catch (Exception e) {
            logger.error("Could not delete YearSchedule by id: {}", yearscheduleId);
            return false;
        }
        return true;
    }

    public boolean updateYearSchedule(int yearscheduleId, YearSchedule yearschedule) {
        try {
            YearSchedule managedYearSchedule = yearscheduledao.findById(yearscheduleId).get();
            managedYearSchedule.setDayschedules(yearschedule.getDayschedules());
            managedYearSchedule.setYear(yearschedule.getYear());
            yearscheduledao.save(managedYearSchedule);
        } catch (Exception e) {
            logger.error("Could not update YearSchedule, id: {}", yearscheduleId);
            return false;
        }
        return true;
    }

    public List<YearSchedule> getYearScheduleList() {
        try {
            return (List<YearSchedule>) yearscheduledao.findAll();
        } catch (Exception e) {
            logger.error("Could not get a YearSchedule List", e);
        }
        return null;
    }

}
