package com.danielsedoff.college.schedule.dao;

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

    public List<Integer> getIdList()  {
        return jdbcTemplate.queryForList(SQL_SELECT_ID_FROM_LESSONS, Integer.class);
    }

    public boolean update(Integer id, Lesson lesson)  {
        return jdbcTemplate.update(SQL_UPDATE_LESSONS, lesson.getStartTime(),
                lesson.getEndTime(), lesson.getProfessor().getId(), lesson.getId()) > 0;
    }

    public boolean delete(Lesson lesson)  {
        return jdbcTemplate.update(SQL_DELETE_FROM_LESSONS, lesson.getId()) > 0;
    }

    public boolean create(Lesson lesson)  {
        return jdbcTemplate.update(SQL_INSERT_INTO_LESSONS, lesson.getStartTime(),
                lesson.getEndTime(), lesson.getProfessor().getId()) > 0;
    }

    public Lesson getById(Integer lessonId)  {
        return jdbcTemplate.queryForObject(SQL_SELECT_LESSON_BY_ID,
                new Object[] { lessonId }, new LessonMapper());
    }

    public boolean setLessonGroup(Lesson lesson, Group group)  {
        return (jdbcTemplate.update(SQL_INSERT_LESSON_GROUP, lesson.getId(),
                group.getId()) > 0);
    }

    public List<Group> getGroupsByLesson(Lesson lesson)
            {
        List<Integer> groupIds = jdbcTemplate.queryForList(SQL_SELECT_GROUP_BY_LESSON,
                Integer.class, lesson.getId());
        List<Group> groups = new ArrayList<>();
        for (Integer groupId : groupIds) {
            groups.add(groupdao.getById(groupId));
        }
        return groups;
    }

}
