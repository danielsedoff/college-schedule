package com.danielsedoff.college.schedule.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.jdbc.core.RowMapper;

import com.danielsedoff.college.schedule.model.Professor;

public class ProfessorMapper implements RowMapper<Professor> {

    public Professor mapRow(ResultSet resultSet, int i) throws SQLException {
        Professor professor = new Professor();

        professor.setId(resultSet.getInt("professor_id"));
        professor.setName(resultSet.getString("professor_name"));
        professor.setRanksTitles(new ArrayList<>(
                Arrays.asList(resultSet.getString("professor_ranks").split("\n"))));
        professor.setSpecialNotes(new ArrayList<>(
                Arrays.asList(resultSet.getString("professor_notes").split("\n"))));
        return professor;
    }
}
