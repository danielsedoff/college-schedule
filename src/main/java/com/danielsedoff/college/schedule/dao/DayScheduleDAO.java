package com.danielsedoff.college.schedule.dao;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.mappers.DayScheduleMapper;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
public class DayScheduleDAO implements DAO<DaySchedule> {

    @Autowired
    private LessonDAO lessondao;

    JdbcTemplate jdbcTemplate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final String SQL_SELECT_ID_FROM_DAYSCHEDULES = "SELECT dayschedule_id FROM dayschedules;";
    private static final String SQL_UPDATE_DAYSCHEDULES = "UPDATE dayschedules SET date = ?, hasOverlaps = ? WHERE dayschedule_id = ?;";
    private static final String SQL_DELETE_FROM_DAYSCHEDULES = "DELETE FROM daySchedules WHERE daySchedule_id = ?;";
    private static final String SQL_INSERT_INTO_DAYSCHEDULES = "INSERT INTO daySchedules (date, hasOverlaps) VALUES (?, ?);";
    private static final String SQL_SELECT_DAYSCHEDULE_BY_ID = "SELECT * FROM daySchedules where daySchedule_id = ?";
    private static final String SQL_INSERT_LESSON_DAYSCHEDULE = "INSERT INTO lesson_dayschedule (lesson_id, dayschedule_id) VALUES (?, ?);";
    private static final String SQL_SELECT_LESSONS_BY_DAYSCHEDULE = "SELECT lesson_id FROM lesson_dayschedule WHERE dayschedule_id = ?";

    @Autowired
    public DayScheduleDAO(JdbcTemplate jdbcTemplate)  {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList()  {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_DAYSCHEDULES, Integer.class);
    }

    public boolean update(Integer id, DaySchedule daySchedule)
             {
        return jdbcTemplate.update(SQL_UPDATE_DAYSCHEDULES, daySchedule.getDay(),
                daySchedule.getHasOverlaps(), daySchedule.getId()) > 0;
    }

    public boolean delete(DaySchedule daySchedule)  {
        return jdbcTemplate.update(SQL_DELETE_FROM_DAYSCHEDULES, daySchedule.getId()) > 0;
    }

    public boolean create(DaySchedule daySchedule)  {
        String dateText = daySchedule.getDay().format(formatter);
        return jdbcTemplate.update(SQL_INSERT_INTO_DAYSCHEDULES, dateText,
                daySchedule.getHasOverlaps()) > 0;
    }

    public DaySchedule getById(Integer dayScheduleId)  {
        return jdbcTemplate.queryForObject(SQL_SELECT_DAYSCHEDULE_BY_ID,
                new Object[] { dayScheduleId }, new DayScheduleMapper());
    }

    public boolean setLessonDayschedule(Lesson lesson, DaySchedule dayschedule)
             {
        return (jdbcTemplate.update(SQL_INSERT_LESSON_DAYSCHEDULE, lesson.getId(),
                dayschedule.getId()) > 0);
    }

    public List<Lesson> getLessonsByDayschedule(DaySchedule dayschedule)
            {
        List<Integer> lessonIds = jdbcTemplate.queryForList(
                SQL_SELECT_LESSONS_BY_DAYSCHEDULE, Integer.class, dayschedule.getId());
        List<Lesson> lessons = new ArrayList<>();
        for (Integer lessonId : lessonIds) {
            lessons.add(lessondao.getById(lessonId));
        }
        return lessons;
    }

}
