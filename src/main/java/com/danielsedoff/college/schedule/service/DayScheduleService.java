package com.danielsedoff.college.schedule.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DayScheduleRepository;
import com.danielsedoff.college.schedule.model.DaySchedule;

@Service
public class DayScheduleService {

    @Autowired
    private DayScheduleRepository dayscheduledao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private static Logger logger = LoggerFactory.getLogger(DayScheduleService.class);

    public boolean createDaySchedule(DaySchedule dayschedule) {
        return dayscheduledao.save(dayschedule) != null;
    }

    public DaySchedule getDayScheduleById(int dayschedId) {
        Optional<DaySchedule> result = dayscheduledao.findById(dayschedId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteDayScheduleById(int dayschedId) {
        try {
            dayscheduledao.deleteById(dayschedId);
        } catch (Exception e) {
            logger.error("Could not delete Day Schedule by id: {}", dayschedId);
            return false;
        }
        return true;
    }

    public boolean updateDaySchedule(int dayschedId, LocalDateTime date, boolean hasOverlaps) {
        try {
            DaySchedule managedDaysched = dayscheduledao.findById(dayschedId).get();
            managedDaysched.setDay(date.format(formatter));
            managedDaysched.setHasOverlaps(hasOverlaps);
            dayscheduledao.save(managedDaysched);
        } catch (Exception e) {
            logger.error("Could not update Course, id: {}", dayschedId);
        }
        return false;
    }

    public List<DaySchedule> getDayScheduleList() {
        try {
            return (List<DaySchedule>) dayscheduledao.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Course List", e);
        }
        return null;
    }

}
