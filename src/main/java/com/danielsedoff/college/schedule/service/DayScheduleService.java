package com.danielsedoff.college.schedule.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.DaySchedule;

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

    public List<Integer> getDayscheduleIdList() {
        return dayscheduledao.getIdList();
    }

    public boolean createDaySchedule(LocalDateTime date) {
        boolean hasOverlaps = false;
        DaySchedule ds = new DaySchedule();
        ds.setDay(date);
        ds.setHasOverlaps(hasOverlaps);
        return dayscheduledao.create(ds);
    }

    public boolean updateDaySchedule(int dayschedId, LocalDateTime date,
            boolean hasOverlaps) {
        DaySchedule daysched = new DaySchedule();
        daysched.setDay(date);
        daysched.setHasOverlaps(hasOverlaps);
        return dayscheduledao.update(dayschedId, daysched);
    }

    public boolean deleteDayScheduleById(int dayschedId) {
        return dayscheduledao.delete(dayscheduledao.getById(dayschedId));
    }

    public DaySchedule getDayScheduleById(int dayschedId) {
        return dayscheduledao.getById(dayschedId);
    }

    public boolean setLessonDaySchedule(int lessonId, int dayschedId) {
        Lesson lesson = lessondao.getById(lessonId);
        DaySchedule daysched = dayscheduledao.getById(dayschedId);
        return dayscheduledao.setLessonDayschedule(lesson, daysched);
    }

    public List<Lesson> getLessonsByDayScheduleById(int dayschedId) {
        DaySchedule daysched = dayscheduledao.getById(dayschedId);
        return dayscheduledao.getLessonsByDayschedule(daysched);
    }

}
