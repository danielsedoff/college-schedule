package com.danielsedoff.college.schedule.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAO;
import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;
import com.danielsedoff.college.schedule.model.Professor;

@Service
public class LessonService {
    private DAO<Lesson> lessondao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public LessonService(DAO<Professor> professordao, DAO<Lesson> lessondao, DAO<Group> groupdao) {
        this.lessondao = lessondao;
    }

    private static Logger logger = LoggerFactory.getLogger(LessonService.class);

    public List<Lesson> getLessonList() {
        List<Lesson> result = null;
        try {
            result = lessondao.getList();
        } catch (DAOException e) {
            logger.error("Could not get a Lesson list", e);
        }
        return result;
    }

    public Lesson getLessonById(int lessonId) {
        Lesson result = null;
        try {
            result = lessondao.getById(lessonId);
        } catch (DAOException e) {
            logger.error("Could not Get a Lesson by ID, lessonId: {}", lessonId);
        }
        return result;
    }

    public boolean createLesson(Lesson lesson) {
        boolean result = false;
        try {
            result = lessondao.create(lesson);
        } catch (DAOException e) {
            logger.error("Could not Create a Lesson", e);
        }
        return result;
    }

    public boolean deleteLessonById(int lessonId) {
        boolean result = false;
        try {
            result = lessondao.delete(lessondao.getById(lessonId));
        } catch (DAOException e) {
            logger.error("Could not Delete a Lesson by ID, lessonId: {}", lessonId);
        }
        return result;
    }

    public boolean updateLesson(int lessonId, Lesson lesson) {
        boolean result = false;
        try {
            result = lessondao.update(lessonId, lesson);
        } catch (DAOException e) {
            logger.error("Could not Update a Lesson, lessonId: {}", lessonId);
        }
        return result;
    }

    public List<Integer> getLessonIdList() {
        List<Integer> result = null;
        try {
            result = lessondao.getIdList();
        } catch (DAOException e) {
            logger.error("Could not Get a Lesson ID List", e);
        }
        return result;
    }

}
