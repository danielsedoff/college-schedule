package com.danielsedoff.college.schedule.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
class LessonDAOTest {

    private JdbcTemplate jdbctemplate = new JdbcTemplate();
    private LessonDAO lessondao = new LessonDAO(this.jdbctemplate);
    private GroupDAO groupdao = new GroupDAO(this.jdbctemplate);

    @Test
    void testGetIdList() {
        List<Integer> result = lessondao.getIdList();
        Integer[] ints = { 1, 2, 3, 4 };
        List<Integer> expectedResult = List.of(ints);
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdate() {
        int id = 1;
        Lesson lesson = lessondao.getById(id);
        LocalDateTime today = LocalDateTime.now();
        lesson.setStartTime(today);
        lessondao.update(id, lesson);
        assertEquals(today, lessondao.getById(id).getStartTime());
    }

    @Test
    void testDelete() {
        int expectedResult = lessondao.getIdList().size() - 1;
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lessondao.delete(lesson);
        assertEquals(expectedResult, lessondao.getIdList().size());
    }

    @Test
    void testCreate() {
        int expectedSize = lessondao.getIdList().size() + 1;
        Lesson lesson = new Lesson();
        LocalDateTime now = LocalDateTime.now();
        lesson.setStartTime(now);
        lessondao.create(lesson);
        assertEquals(expectedSize, lessondao.getIdList().size());
        assertEquals(now, lessondao.getById(5).getStartTime());
    }

    @Test
    void testGetById() {
        Lesson lesson = lessondao.getById(1);
        assertNotNull(lesson);
    }

    @Test
    void testSetLessonGroup() {
        Lesson lesson = lessondao.getById(3);
        Group group = new Group();
        String note = "Some New Group";
        List<String> noteList = new ArrayList<>();
        noteList.add(note);
        group.setSpecialNotes(noteList);
        lessondao.setLessonGroup(lesson, group);
        assertEquals(noteList, lessondao.getGroupsByLesson(groupdao, lesson));
    }

    @Test
    void testGetGroupsByLesson() {
        Lesson lesson = lessondao.getById(3);
        assertNotNull(lessondao.getGroupsByLesson(groupdao, lesson));
    }

}
