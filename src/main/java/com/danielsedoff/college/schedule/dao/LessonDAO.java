package com.danielsedoff.college.schedule.dao;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.danielsedoff.college.schedule.dao.mappers.LessonMapper;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
public class LessonDAO implements DAO<Lesson> {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    
    @Autowired
    private GroupDAO groupdao;
    JdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_ID_FROM_LESSONS = "SELECT lesson_id FROM lessons;";
    private static final String SQL_UPDATE_LESSONS = "UPDATE lessons SET start_time = ?, end_time = ?, professor_id = ? WHERE lesson_id = ?;";
    private static final String SQL_DELETE_FROM_LESSONS = "DELETE FROM lessons WHERE lesson_id = ?;";
    private static final String SQL_INSERT_INTO_LESSONS = "INSERT INTO lessons (start_time, end_time, professor_id) VALUES (?, ?, ?);";
    private static final String SQL_SELECT_LESSON_BY_ID = "SELECT * FROM lessons where lesson_id = ?";
    private static final String SQL_INSERT_LESSON_GROUP = "INSERT INTO lesson_group (lesson_id, group_id) VALUES (?, ?);";
    private static final String SQL_SELECT_GROUP_BY_LESSON = "SELECT group_id FROM lesson_group WHERE lesson_id = ?";

    @Autowired
    public LessonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Integer> getIdList() throws DAOException {
        List<Integer> result = null;
        try {
            result = jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_LESSONS, Integer.class);
        } catch (Exception e) {
            throw new DAOException("Could not get Id List", e);
        }
        return result;
    }

    public boolean update(Integer id, Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_UPDATE_LESSONS, lesson.getStartTime().format(formatter),
                    lesson.getEndTime().format(formatter), lesson.getProfessorId(),
                    lesson.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not update", e);
        }
        return result;
    }

    public boolean delete(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_DELETE_FROM_LESSONS, lesson.getId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not delete", e);
        }
        return result;
    }

    public boolean create(Lesson lesson) throws DAOException {
        boolean result = false;
        try {
            result = jdbcTemplate.update(SQL_INSERT_INTO_LESSONS, lesson.getStartTime().format(formatter),
                    lesson.getEndTime().format(formatter), lesson.getProfessorId()) > 0;
        } catch (Exception e) {
            throw new DAOException("Could not create", e);
        }
        return result;
    }

    public Lesson getById(Integer lessonId) throws DAOException {
        Lesson result = null;
        try {
            result = jdbcTemplate.queryForObject(SQL_SELECT_LESSON_BY_ID,
                    new Object[] { lessonId }, new LessonMapper());
        } catch (Exception e) {
            throw new DAOException("Could not get By Id", e);
        }
        return result;
    }

    public boolean setLessonGroup(Lesson lesson, Group group) throws DAOException {
        boolean result = false;
        try {
            result = (jdbcTemplate.update(SQL_INSERT_LESSON_GROUP, lesson.getId(),
                    group.getId()) > 0);
        } catch (Exception e) {
            throw new DAOException("Could not set Lesson Group", e);
        }
        return result;
    }

    public List<Group> getGroupsByLesson(Lesson lesson) throws DAOException {
        List<Group> groups = new ArrayList<>();
        try {
            List<Integer> groupIds = jdbcTemplate.queryForList(SQL_SELECT_GROUP_BY_LESSON,
                    Integer.class, lesson.getId());
            for (Integer groupId : groupIds) {
                groups.add(groupdao.getById(groupId));
            }
        } catch (Exception e) {
            throw new DAOException("Could not get Groups By Lesson", e);
        }
        return groups;
    }
}
