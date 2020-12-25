package com.danielsedoff.college.schedule.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.DAOException;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;

@Service
public class LessonService {

    private LessonDAO lessondao;
    private GroupDAO groupdao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public LessonService(ProfessorDAO professordao, LessonDAO lessondao,
            GroupDAO groupdao) {
        this.lessondao = lessondao;
        this.groupdao = groupdao;
    }

    private static Logger logger = LoggerFactory.getLogger(LessonService.class);

    public List<Group> getGroupsByLessonId(int lessonId) {
        List<Group> result = null;
        try {
            Lesson lesson = lessondao.getById(lessonId);
            result = lessondao.getGroupsByLesson(lesson);
        } catch (DAOException e) {
            logger.error("Could not Get Groups by Lesson ID", e);
        }
        return result;
    }

    public boolean setLessonGroup(int lessonId, int groupId) {
        boolean result = false;
        try {
            result = lessondao.setLessonGroup(lessondao.getById(lessonId),
                    groupdao.getById(groupId));
        } catch (DAOException e) {
            logger.error("Could not Set Lesson-Group Relation", e);
        }
        return result;
    }

    public Lesson getLessonById(int lessonId) {
        Lesson result = null;
        try {
            result = lessondao.getById(lessonId);
        } catch (DAOException e) {
            logger.error("Could not Get a Lesson by ID", e);
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
            logger.error("Could not Delete a Lesson by ID", e);
        }
        return result;
    }

    public boolean updateLesson(int lessonId, Lesson lesson) {
        boolean result = false;
        try {
            result = lessondao.update(lessonId, lesson);
        } catch (DAOException e) {
            logger.error("Could not Update a Lesson", e);
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
