package com.danielsedoff.college.schedule.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

@Service
public class DayScheduleService {

    private DayScheduleDAO dayscheduledao;
    private LessonDAO lessondao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public DayScheduleService(DayScheduleDAO dayscheduledao, LessonDAO lessondao) {
        this.dayscheduledao = dayscheduledao;
        this.lessondao = lessondao;
    }

    private static Logger logger = LoggerFactory.getLogger(DayScheduleService.class);

    public List<Integer> getDayscheduleIdList() {
        List<Integer> result = null;
        try {
            result = dayscheduledao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not get Day Schedule ID List", e);
        }
        return result;
    }

    public boolean createDaySchedule(LocalDateTime date) {
        boolean hasOverlaps = false;
        DaySchedule ds = new DaySchedule();
        ds.setDay(date);
        ds.setHasOverlaps(hasOverlaps);
        boolean result = false;
        try {
            result = dayscheduledao.create(ds);
        } catch (DAOException e) {
            logger.error("Could not create a new Day Schedule with date", date);
        }
        return result;
    }

    public boolean updateDaySchedule(int dayschedId, LocalDateTime date,
            boolean hasOverlaps) {
        DaySchedule daysched = new DaySchedule();
        daysched.setDay(date);
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

    public boolean setLessonDaySchedule(int lessonId, int dayschedId) {
        boolean result = false;
        try {
            Lesson lesson = lessondao.getById(lessonId);
            DaySchedule daysched = dayscheduledao.getById(dayschedId);
            result = dayscheduledao.setLessonDayschedule(lesson, daysched);
        } catch (DAOException e) {
            logger.error("Could not Set Lesson-Day Schedule Relation, lessonId: {}, dayschedId: {}", lessonId, dayschedId);
        }
        return result;
    }

    public List<Lesson> getLessonsByDayScheduleById(int dayschedId) {
        List<Lesson> result = null;
        try {
            DaySchedule daysched = dayscheduledao.getById(dayschedId);
            result = dayscheduledao.getLessonsByDayschedule(daysched);
        } catch (DAOException e) {
            logger.error("Could not Get Lesson-Day Schedule Relation, dayschedId: {}", dayschedId);
        }
        return result;
    }

}
