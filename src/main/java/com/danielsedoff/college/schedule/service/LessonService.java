package com.danielsedoff.college.schedule.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsedoff.college.schedule.dao.LessonRepository;
import com.danielsedoff.college.schedule.model.Lesson;

@Service
public class LessonService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    private LessonRepository lessondao;

    private static Logger logger = LoggerFactory.getLogger(LessonService.class);

    public boolean createLesson(Lesson lesson) {
        return lessondao.save(lesson) != null;
    }

    public Lesson getLessonById(int lessonId) {
        Optional<Lesson> result = lessondao.findById(lessonId);
        if (null == result) {
            return null;
        }
        return result.get();
    }

    public boolean deleteLessonById(int lessonId) {
        try {
            lessondao.deleteById(lessonId);
        } catch (Exception e) {
            logger.error("Could not delete Lesson by id: {}", lessonId);
            return false;
        }
        return true;
    }

    public boolean updateLesson(int lessonId, Lesson lesson) {
        try {
            Lesson managedLesson = lessondao.findById(lessonId).get();
            managedLesson.setDayschedule(lesson.getDayschedule());
            managedLesson.setEndTime(lesson.getEndTime());
            managedLesson.setStartTime(lesson.getStartTime());
            managedLesson.setGroup(lesson.getGroup());
            managedLesson.setProfessor(lesson.getProfessor());
            lessondao.save(managedLesson);
        } catch (Exception e) {
            logger.error("Could not update Lesson, id: {}", lessonId);
            return false;
        }
        return true;
    }

    public List<Lesson> getLessonList() {
        try {
            return (List<Lesson>) lessondao.findAll();
        } catch (Exception e) {
            logger.error("Could not get a Lesson List", e);
        }
        return null;
    }

}
