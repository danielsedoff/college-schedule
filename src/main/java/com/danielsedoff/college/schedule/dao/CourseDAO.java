package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.mappers.CourseMapper;
import com.danielsedoff.college.schedule.model.Course;
import com.danielsedoff.college.schedule.model.Professor;

@Component
public class CourseDAO implements DAO<Course> {

    @Autowired
    private ProfessorDAO professordao;

    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_COURSES = "SELECT course_id FROM courses;";
    private static final String SQL_UPDATE_COURSES = "UPDATE courses SET course_name = ?, course_description = ? WHERE course_id = ?;";
    private static final String SQL_DELETE_FROM_COURSES = "DELETE FROM courses WHERE course_id = ?;";
    private static final String SQL_INSERT_INTO_COURSES = "INSERT INTO courses (course_name, course_description) VALUES (?, ?);";
    private static final String SQL_SELECT_COURSE_BY_ID = "SELECT * FROM courses where course_id = ?";
    private static final String SQL_INSERT_COURSE_PROFESSOR = "INSERT INTO course_professor (course_id, professor_id) VALUES(?, ?)";
    private static final String SQL_SELECT_PROFESSOR_BY_COURSE = "SELECT professor_id FROM course_professor WHERE course_id = ?";
    private static final String SQL_DELETE_COURSE_PROFESSOR = "DELETE FROM course_professor WHERE course_id = ?;";

    @Autowired
    public CourseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList()  {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_COURSES, Integer.class);
    }

    public Course getById(Integer id)  {
        return jdbcTemplate.queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[] { id },
                new CourseMapper());
    }

    public boolean delete(Course course)  {
        deleteCourseProfessorByCourse(course);
        return jdbcTemplate.update(SQL_DELETE_FROM_COURSES, course.getId()) > 0;
    }

    public boolean update(Integer id, Course course)  {
        return jdbcTemplate.update(SQL_UPDATE_COURSES, course.getName(),
                course.getCourseDescription(), course.getId()) > 0;
    }

    public boolean create(Course course)  {
        return jdbcTemplate.update(SQL_INSERT_INTO_COURSES, course.getName(),
                course.getCourseDescription()) > 0;
    }

    public boolean setCourseProfessor(Course course, List<Professor> professors)
             {
        // TODO: Make it batch.
        boolean result = false;
        for (int i = 0; i < professors.size(); i++) {
            jdbcTemplate.update(SQL_INSERT_COURSE_PROFESSOR, course.getId(),
                    professors.get(i).getId());
        }
        return result;
    }

    public boolean deleteCourseProfessorByCourse(Course course)
             {
        return 0 < jdbcTemplate.update(SQL_DELETE_COURSE_PROFESSOR, course.getId());
    }

    public List<Professor> getProfessorByCourse(Course course) {
        List<Integer> professorIds = jdbcTemplate.queryForList(
                SQL_SELECT_PROFESSOR_BY_COURSE, Integer.class, course.getId());
        List<Professor> professors = new ArrayList<>();
        for (Integer professorId : professorIds) {
            if (0 == professorId)
                continue;
            professors.add(professordao.getById(professorId));
        }
        return professors;
    }

}