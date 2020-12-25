package com.danielsedoff.college.schedule.dao;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(DayScheduleDAO.class);
    
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
    public DayScheduleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            // DEBUG
            logger.info("DS DAO entered");
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_DAYSCHEDULES,
                    Integer.class);
        } catch (Exception e) {
            throw new DAOException("Could not get Id List", e);
        }
        return result;
    }

    public boolean update(Integer id, DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_UPDATE_DAYSCHEDULES, daySchedule.getDay().format(formatter),
                    daySchedule.getHasOverlaps(), daySchedule.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not update", e);
        }
        return result;
    }

    public boolean delete(DaySchedule daySchedule) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_DAYSCHEDULES,
                    daySchedule.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not delete", e);
        }
        return result;

    }

    public boolean create(DaySchedule daySchedule) throws DAOException {
        String dateText = daySchedule.getDay().format(formatter);
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_DAYSCHEDULES, dateText,
                    daySchedule.getHasOverlaps()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not create", e);
        }
        return result;
    }

    public DaySchedule getById(Integer dayScheduleId) throws DAOException {
        DaySchedule result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_DAYSCHEDULE_BY_ID,
                    new Object[] { dayScheduleId }, new DayScheduleMapper());
        } catch (Exception e) {
            throw new DAOException("Could not get By Id", e);
        }
        return result;
    }

    public boolean setLessonDayschedule(Lesson lesson, DaySchedule dayschedule)
            throws DAOException {
        boolean result = false;
        try {
            result = (jdbcTemplate.update(SQL_INSERT_LESSON_DAYSCHEDULE, lesson.getId(),
                    dayschedule.getId()) > 0);
        } catch (Exception e) {
            throw new DAOException("Could not set Lesson Dayschedule", e);
        }
        return result;
    }

    public List<Lesson> getLessonsByDayschedule(DaySchedule dayschedule)
            throws DAOException {
        List<Lesson> lessons = new ArrayList<>();
        try {
            List<Integer> lessonIds = jdbcTemplate.queryForList(
                    SQL_SELECT_LESSONS_BY_DAYSCHEDULE, Integer.class,
                    dayschedule.getId());
            for (Integer lessonId : lessonIds) {
                if(0 == lessonId) continue;
                lessons.add(lessondao.getById(lessonId));
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Lessons By Dayschedule", e);
        }
        return lessons;
    }

}
