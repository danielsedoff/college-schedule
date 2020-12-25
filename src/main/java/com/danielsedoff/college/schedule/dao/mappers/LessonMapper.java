package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Lesson;

public class LessonMapper implements RowMapper<Lesson> {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Lesson mapRow(ResultSet resultSet, int i) throws SQLException {
        Lesson lesson = new Lesson();

        lesson.setId(resultSet.getInt("group_id"));
        lesson.setStartTime(
                LocalDateTime.parse(resultSet.getString("start_time"), formatter));
        lesson.setEndTime(
                LocalDateTime.parse(resultSet.getString("end_time"), formatter));
        lesson.setProfessor(null);
        // TODO: Implement Lesson-Professor relation
        lesson.setGroups(null);
        // TODO: Implement Lesson-Group relation
        return lesson;
    }
}
