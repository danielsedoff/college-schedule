package com.danielsedoff.college.schedule.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.DaySchedule;
import static com.danielsedoff.college.schedule.lang.UserMessages.*;

@Service
public class DayScheduleCommandExecutor {

    private DayScheduleDAO dayscheduledao;
    private LessonDAO lessondao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public DayScheduleCommandExecutor(DayScheduleDAO dayscheduledao,
            LessonDAO lessondao) {
        this.dayscheduledao = dayscheduledao;
        this.lessondao = lessondao;
    }

    public String getDayscheduleIdList() {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = dayscheduledao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String createDaySchedule(String[] arguments) {
        boolean result = false;
        String dateStr = arguments[0];
        boolean hasOverlaps = false;
        DaySchedule ds = new DaySchedule();
        ds.setDay(LocalDateTime.parse(dateStr, formatter));
        ds.setHasOverlaps(hasOverlaps);
        result = dayscheduledao.create(ds);
        return result ? SUCCESS : FAILURE;
    }

    public String updateDaySchedule(String[] arguments) {
        boolean result = false;
        String dsIdStr = arguments[0];
        String hasOverlapsStr = arguments[1];
        int dayschedId = -1;
        try {
            dayschedId = Integer.parseInt(dsIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        int hasOverlaps = -1;
        try {
            hasOverlaps = Integer.parseInt(hasOverlapsStr);
        } catch (Exception e) {
            return "Wrong Number of Overlaps.";
        }
        String dateStr = arguments[2];
        DaySchedule daysched = new DaySchedule();
        daysched.setDay(LocalDateTime.parse(dateStr, formatter));
        daysched.setHasOverlaps(hasOverlaps > 0);
        result = dayscheduledao.update(dayschedId, daysched);
        return result ? SUCCESS : FAILURE;
    }

    public String deleteDaySchedule(String[] arguments) {
        boolean result = false;
        String dayschedIdStr = arguments[0];
        int dayschedId = -1;
        try {
            dayschedId = Integer.parseInt(dayschedIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        result = dayscheduledao.delete(dayscheduledao.getById(dayschedId));
        return result ? SUCCESS : FAILURE;
    }

    public String getDayScheduleById(String[] arguments) {
        String dayschedIdStr = arguments[0];
        int dayschedId = -1;
        try {
            dayschedId = Integer.parseInt(dayschedIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        return dayscheduledao.getById(dayschedId).toString();
    }

    public String setLessonDaySchedule(String[] arguments) {
        String lessonIdStr = arguments[0];
        int lessonId = -1;
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong Lesson ID.";
        }
        String dayschedIdStr = arguments[1];
        int dayschedId = -1;
        try {
            dayschedId = Integer.parseInt(dayschedIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        boolean result = false;
        Lesson lesson = lessondao.getById(lessonId);
        DaySchedule daysched = dayscheduledao.getById(dayschedId);
        result = dayscheduledao.insertLessonDayschedule(lesson, daysched);
        return result ? SUCCESS : FAILURE;
    }

    public String getLessonsByDaySchedule(String[] arguments) {
        String dayschedIdStr = arguments[0];
        int dayschedId = -1;
        try {
            dayschedId = Integer.parseInt(dayschedIdStr);
        } catch (Exception e) {
            return WRONG_DAY_SCHEDULE_ID;
        }
        DaySchedule daysched = null;
        try {
            daysched = dayscheduledao.getById(dayschedId);
        } catch (Exception e) {
            return "Could not find day schedule.";
        }
        StringBuilder result = new StringBuilder();
        List<Lesson> lessons = dayscheduledao.getLessonsByDayschedule(lessondao,
                daysched);
        for (Lesson lesson : lessons) {
            result.append(System.lineSeparator()).append(lesson.toString());
        }
        return result.toString();
    }

}
