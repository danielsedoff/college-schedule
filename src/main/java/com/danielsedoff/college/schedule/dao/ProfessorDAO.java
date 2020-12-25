package com.danielsedoff.college.schedule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.DAOException.ProfessorDAOException;
import com.danielsedoff.college.schedule.dao.mappers.ProfessorMapper;
import com.danielsedoff.college.schedule.model.Professor;

@Component
public class ProfessorDAO implements DAO<Professor> {

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_PROFESSOR = "SELECT professor_id FROM professors;";
    private static final String SQL_UPDATE_PROFESSORS = "UPDATE professors SET professor_name = ?, professor_ranks = ?, professor_notes = ?, department_id = ? WHERE professor_id = ?;";
    private static final String SQL_DELETE_FROM_PROFESSORS = "DELETE FROM students WHERE student_id = ?;";
    private static final String SQL_INSERT_INTO_PROFESSORS = "INSERT INTO professors (professor_name, professor_ranks, professor_notes, department_id) VALUES (?, ?, ?,?);";
    private static final String SQL_SELECT_PROFESSOR_BY_ID = "SELECT * FROM professors where professor_id = ?";

    @Autowired
    public ProfessorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws ProfessorDAOException {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_PROFESSOR, Integer.class);
    }

    public Professor getById(Integer professorId) throws ProfessorDAOException {
        return jdbcTemplate.queryForObject(SQL_SELECT_PROFESSOR_BY_ID,
                new Object[] { professorId }, new ProfessorMapper());
    }

    public boolean delete(Professor professor) throws ProfessorDAOException {
        return jdbcTemplate.update(SQL_DELETE_FROM_PROFESSORS, professor.getId()) > 0;
    }

    public boolean update(Integer id, Professor professor) throws ProfessorDAOException {
        return jdbcTemplate.update(SQL_UPDATE_PROFESSORS, professor.getName(),
                professor.getRanksTitles(), professor.getSpecialNotes(),
                professor.getDepartmentId(), professor.getId()) > 0;
    }

    public boolean create(Professor professor) throws ProfessorDAOException {
        return jdbcTemplate.update(SQL_INSERT_INTO_PROFESSORS, professor.getName(),
                professor.getRanksTitles(), professor.getSpecialNotes(),
                professor.getDepartmentId()) > 0;
    }
}
