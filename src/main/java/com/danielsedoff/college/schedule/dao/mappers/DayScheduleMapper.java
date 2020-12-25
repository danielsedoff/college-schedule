package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.DaySchedule;

public class DayScheduleMapper implements RowMapper<DaySchedule> {

    public DaySchedule mapRow(ResultSet resultSet, int i) throws SQLException {
        DaySchedule daySchedule = new DaySchedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        daySchedule.setId(resultSet.getInt("dayschedule_id"));
        daySchedule.setDay(LocalDateTime.parse(resultSet.getString("date"), formatter));
        daySchedule.setHasOverlaps(resultSet.getInt("dayschedule_id") > 0);
        return daySchedule;
    }
}
