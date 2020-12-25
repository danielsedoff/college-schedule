package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Professor;

public class ProfessorMapper implements RowMapper<Professor> {

    public Professor mapRow(ResultSet resultSet, int i) throws SQLException {
        Professor professor = new Professor();

        professor.setId(resultSet.getInt("professor_id"));
        professor.setName(resultSet.getString("professor_name"));
        professor.setRanksTitles(resultSet.getString("professor_ranks"));
        professor.setSpecialNotes(resultSet.getString("professor_notes"));
        professor.setDepartmentId(resultSet.getInt("department_id"));
        return professor;
    }
}
