package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.YearSchedule;

public class YearScheduleMapper implements RowMapper<YearSchedule> {

    public YearSchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        YearSchedule yearSchedule = new YearSchedule();
        yearSchedule.setId(resultSet.getInt("yearschedule_id"));
        yearSchedule.setYear(resultSet.getInt("year"));
        yearSchedule.setLearningDays(null);
        // TODO: Implement YearSchedule-DaySchedule relation
        return yearSchedule;
    }
}
