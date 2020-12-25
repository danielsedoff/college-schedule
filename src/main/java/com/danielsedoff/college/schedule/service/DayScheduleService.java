package com.danielsedoff.college.schedule.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException.DayScheduleDAOException;
import com.danielsedoff.college.schedule.dao.DAOException.LessonDAOException;
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

    public List<Integer> getDayscheduleIdList() throws DayScheduleDAOException {
        return dayscheduledao.getIdList();
    }

    public boolean createDaySchedule(LocalDateTime date) throws DayScheduleDAOException {
        boolean hasOverlaps = false;
        DaySchedule ds = new DaySchedule();
        ds.setDay(date);
        ds.setHasOverlaps(hasOverlaps);
        return dayscheduledao.create(ds);
    }

    public boolean updateDaySchedule(int dayschedId, LocalDateTime date,
            boolean hasOverlaps) throws DayScheduleDAOException {
        DaySchedule daysched = new DaySchedule();
        daysched.setDay(date);
        daysched.setHasOverlaps(hasOverlaps);
        return dayscheduledao.update(dayschedId, daysched);
    }

    public boolean deleteDayScheduleById(int dayschedId) throws DayScheduleDAOException {
        return dayscheduledao.delete(dayscheduledao.getById(dayschedId));
    }

    public DaySchedule getDayScheduleById(int dayschedId) throws DayScheduleDAOException {
        return dayscheduledao.getById(dayschedId);
    }

    public boolean setLessonDaySchedule(int lessonId, int dayschedId)
            throws DayScheduleDAOException, LessonDAOException {
        Lesson lesson = lessondao.getById(lessonId);
        DaySchedule daysched = dayscheduledao.getById(dayschedId);
        return dayscheduledao.setLessonDayschedule(lesson, daysched);
    }

    public List<Lesson> getLessonsByDayScheduleById(int dayschedId)
            throws DayScheduleDAOException, LessonDAOException {
        DaySchedule daysched = dayscheduledao.getById(dayschedId);
        return dayscheduledao.getLessonsByDayschedule(daysched);
    }

}
