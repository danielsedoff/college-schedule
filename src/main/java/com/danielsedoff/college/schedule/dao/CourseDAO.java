package com.danielsedoff.college.schedule.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(CourseDAO.class);

    public List<Integer> getIdList() throws DAOException {

        List<Integer> result = null;
        try {
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_COURSES, Integer.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public Course getById(Integer id) throws DAOException {
        Course result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_COURSE_BY_ID,
                    new Object[] { id }, new CourseMapper());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean delete(Course course) throws DAOException {

        boolean result = false;
        deleteCourseProfessorByCourse(course);
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_COURSES, course.getId()) > 0;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean update(Integer id, Course course) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_UPDATE_COURSES, course.getName(),
                    course.getCourseDescription(), course.getId()) > 0;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;
    }

    public boolean create(Course course) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_COURSES, course.getName(),
                    course.getCourseDescription()) > 0;
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean setCourseProfessor(Course course, List<Professor> professors)
            throws DAOException {
        // TODO: Make it batch.
        boolean result = false;
        try {
            for (int i = 0; i < professors.size(); i++) {
                jdbcTemplate.update(SQL_INSERT_COURSE_PROFESSOR, course.getId(),
                        professors.get(i).getId());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public boolean deleteCourseProfessorByCourse(Course course) throws DAOException {
        boolean result = false;
        try {
            result = 0 < jdbcTemplate.update(SQL_DELETE_COURSE_PROFESSOR, course.getId());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return result;

    }

    public List<Professor> getProfessorByCourse(Course course) throws DAOException {
        List<Professor> professors = new ArrayList<>();
        try {
            List<Integer> professorIds = jdbcTemplate.queryForList(
                    SQL_SELECT_PROFESSOR_BY_COURSE, Integer.class, course.getId());
            for (Integer professorId : professorIds) {
                if (0 == professorId)
                    continue;
                professors.add(professordao.getById(professorId));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new DAOException(e.getMessage(), e);
        }
        return professors;
    }

}