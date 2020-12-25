package com.danielsedoff.college.schedule.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.model.YearSchedule;
import com.danielsedoff.college.schedule.repositories.YearScheduleRepository;

@Service
public class YearScheduleService {

    @Autowired
    private YearScheduleRepository yearscheduleRepo;

    private static Logger logger = LoggerFactory.getLogger(YearScheduleService.class);

    public boolean createYearSchedule(YearSchedule yearschedule) {
        return yearscheduleRepo.save(yearschedule) != null;
    }

    public YearSchedule getYearScheduleById(int yearscheduleId) {
        Optional<YearSchedule> result = yearscheduleRepo.findById(yearscheduleId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteYearScheduleById(int yearscheduleId) {
        try {
            yearscheduleRepo.deleteById(yearscheduleId);
        } catch (Exception e) {
            logger.error("Could not delete YearSchedule by id: {}", yearscheduleId);
            return false;
        }
        return true;
    }

    public boolean updateYearSchedule(int yearscheduleId, YearSchedule yearschedule) {
        try {
            YearSchedule managedYearSchedule = yearscheduleRepo.findById(yearscheduleId).get();
            managedYearSchedule.setDayschedules(yearschedule.getDayschedules());
            managedYearSchedule.setYear(yearschedule.getYear());
            yearscheduleRepo.save(managedYearSchedule);
        } catch (Exception e) {
            logger.error("Could not update YearSchedule, id: {}", yearscheduleId);
            return false;
        }
        return true;
    }

    public List<YearSchedule> getYearScheduleList() {
        try {
            return (List<YearSchedule>) yearscheduleRepo.findAll();
        } catch (Exception e) {
            logger.error("Could not get a YearSchedule List", e);
        }
        return null;
    }

}
