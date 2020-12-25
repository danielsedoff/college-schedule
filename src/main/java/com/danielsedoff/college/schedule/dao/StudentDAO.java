package com.danielsedoff.college.schedule.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.mappers.StudentMapper;
import com.danielsedoff.college.schedule.model.Student;

@Component
public class StudentDAO implements DAO<Student> {

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_STUDENTS = "SELECT student_id FROM students;";
    private static final String SQL_UPDATE_STUDENTS = "UPDATE students SET group_id = ?, student_year = ?, student_name = ? WHERE student_id = ?;";
    private static final String SQL_DELETE_FROM_STUDENTS = "DELETE FROM students WHERE student_id = ?;";
    private static final String SQL_INSERT_INTO_STUDENTS = "INSERT INTO students (group_id, student_year, student_name) VALUES (?, ?, ?);";
    private static final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM students where student_id = ?";

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_STUDENTS, Integer.class);
    }

    public Student getById(Integer studentId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID,
                new Object[] { studentId }, new StudentMapper());
    }

    public boolean delete(Student student) {
        return jdbcTemplate.update(SQL_DELETE_FROM_STUDENTS, student.getId()) > 0;
    }

    public boolean update(Integer id, Student student) {
        return jdbcTemplate.update(SQL_UPDATE_STUDENTS, student.getGroup(),
                student.getSchoolYear(), student.getName(), student.getId()) > 0;
    }

    public boolean create(Student student) {
        return jdbcTemplate.update(SQL_INSERT_INTO_STUDENTS, student.getGroup(),
                student.getSchoolYear(), student.getName()) > 0;
    }
}
