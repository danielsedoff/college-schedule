package com.danielsedoff.college.schedule.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    List<Group> getGroupsByLessonId(int lessonId)
            {
        Lesson lesson = lessondao.getById(lessonId);
        return lessondao.getGroupsByLesson(lesson);
    }

    boolean setLessonGroup(int lessonId, int groupId)
            {
        return lessondao.setLessonGroup(lessondao.getById(lessonId),
                groupdao.getById(groupId));
    }

    Lesson getLessonById(int lessonId)  {
        return lessondao.getById(lessonId);
    }

    boolean createLesson(Lesson lesson)  {
        return lessondao.create(lesson);
    }

    boolean deleteLessonById(int lessonId)  {
        return lessondao.delete(lessondao.getById(lessonId));
    }

    boolean updateLesson(int lessonId, Lesson lesson)  {
        return lessondao.update(lessonId, lesson);
    }

    List<Integer> getLessonIdList()  {
        return lessondao.getIdList();
    }
}
