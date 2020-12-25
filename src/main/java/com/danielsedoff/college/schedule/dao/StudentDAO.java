package com.danielsedoff.college.schedule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.mappers.StudentMapper;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class StudentDAO implements DAO<Student> {

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_STUDENTS = "SELECT student_id FROM students;";
    private static final String SQL_UPDATE_STUDENTS = "UPDATE students SET group_id = ?, student_year = ?, student_name = ? WHERE student_id = ?;";
    private static final String SQL_DELETE_FROM_STUDENTS = "DELETE FROM students WHERE student_id = ?;";
    private static final String SQL_INSERT_INTO_STUDENTS = "INSERT INTO students (group_id, student_year, student_name) VALUES (?, ?, ?);";
    private static final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM students where student_id = ?";
    private static final String SQL_REMOVE_ALL_STUDENTS_FROM_GROUP = "UPDATE students SET group_id = 65535 WHERE group_id = ?;";

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_STUDENTS,
                    Integer.class);
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public Student getById(Integer studentId) throws DAOException {
        Student result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                    new Object[] { studentId }, new StudentMapper());
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean delete(Student student) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_STUDENTS, student.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean update(Integer id, Student student) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_UPDATE_STUDENTS, student.getGroup(),
                    student.getSchoolYear(), student.getName(), student.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean create(Student student) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_STUDENTS, student.getGroup(),
                    student.getSchoolYear(), student.getName()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean removeAllStudentsFromGroup(Group group) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_REMOVE_ALL_STUDENTS_FROM_GROUP,
                    group.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }
}
