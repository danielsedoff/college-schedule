package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Course;

public class CourseMapper implements RowMapper<Course> {

    public Course mapRow(ResultSet resultSet, int i) throws SQLException {
        Course course = new Course();
        course.setId(resultSet.getInt("course_id"));
        course.setName(resultSet.getString("course_name"));
        course.setCourseDescription(resultSet.getString("course_description"));
        course.setProfessorId(resultSet.getInt("professor_id"));
        return course;
    }
}
