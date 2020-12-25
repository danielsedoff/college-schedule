package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Student;

public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getInt("student_id"));
        student.setName(resultSet.getString("student_name"));
        student.setSchoolYear(resultSet.getInt("student_year"));
        student.setGroup(null);
        // TODO: Implement Student-Group relation
        return student;
    }
}
