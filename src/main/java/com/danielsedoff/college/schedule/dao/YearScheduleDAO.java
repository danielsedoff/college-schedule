package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.mappers.YearScheduleMapper;
import com.danielsedoff.college.schedule.model.DaySchedule;
import com.danielsedoff.college.schedule.model.YearSchedule;

@Component
public class YearScheduleDAO implements DAO<YearSchedule> {

    @Autowired
    DayScheduleDAO dayscheduledao;

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_YEARS = "SELECT yearschedule_id FROM yearschedules;";
    private static final String SQL_UPDATE_YEARSCHEDULES = "UPDATE yearschedules SET year = ? WHERE yearschedule_id = ?;";
    private static final String SQL_DELETE_FROM_YEARSCHEDULES = "DELETE FROM yearschedules WHERE yearschedule_id = ?;";
    private static final String SQL_INSERT_INTO_YEARSCHEDULES = "INSERT INTO yearschedules (year) VALUES (?);";
    private static final String SQL_SELECT_YEARSCHEDULE_BY_ID = "SELECT * FROM yearschedules where yearschedule_id = ?";
    private static final String SQL_INSERT_YEARSCHEDULE_DAYSCHEDULE = "INSERT INTO yearschedule_dayschedule (yearschedule_id, dayschedule_id) VALUES (?, ?);";
    private static final String SQL_SELECT_DAYSCHEDULES_BY_YEAR = "SELECT dayschedule_id FROM yearschedule_dayschedule WHERE yearschedule_id= ?";

    @Autowired
    public YearScheduleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_YEARS, Integer.class);
        } catch (Exception e) {
            throw new DAOException("Could not get Id List", e);
        }
        return result;
    }

    public boolean update(Integer id, YearSchedule yearschedule) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_UPDATE_YEARSCHEDULES, yearschedule.getYear(),
                    yearschedule.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not update", e);
        }
        return result;
    }

    public boolean delete(YearSchedule yearschedule) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_YEARSCHEDULES,
                    yearschedule.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not delete", e);
        }
        return result;

    }

    public boolean create(YearSchedule yearschedule) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_YEARSCHEDULES,
                    yearschedule.getYear()) > 0;

        } catch (Exception e) {
            throw new DAOException("Could not create", e);
        }
        return result;

    }

    public YearSchedule getById(Integer yearId) throws DAOException {
        YearSchedule result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_YEARSCHEDULE_BY_ID,
                    new Object[] { yearId }, new YearScheduleMapper());
        } catch (Exception e) {
            throw new DAOException("Could not get By Id", e);
        }
        return result;

    }

    public boolean setDayScheduleYearSchedule(DaySchedule dayschedule,
            YearSchedule yearschedule) throws DAOException {
        boolean result = false;
        try {
            result = (jdbcTemplate.update(SQL_INSERT_YEARSCHEDULE_DAYSCHEDULE,
                    dayschedule.getId(), yearschedule.getId()) > 0);
        } catch (Exception e) {
            throw new DAOException("Could not set Day Schedule Year Schedule", e);
        }
        return result;

    }

    public List<DaySchedule> getDayScheduleYearSchedule(YearSchedule yearschedule)
            throws DAOException {
        List<DaySchedule> dayschedules = new ArrayList<>();
        try {
            List<Integer> dayScheduleIds = jdbcTemplate.queryForList(
                    SQL_SELECT_DAYSCHEDULES_BY_YEAR, Integer.class, yearschedule.getId());
            for (Integer dayId : dayScheduleIds) {
                dayschedules.add(dayscheduledao.getById(dayId));
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Day Schedule by Year Schedule", e);
        }

        return dayschedules;
    }

}
