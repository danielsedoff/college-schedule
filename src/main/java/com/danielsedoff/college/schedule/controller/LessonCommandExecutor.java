package com.danielsedoff.college.schedule.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Lesson;

@Component
public class LessonCommandExecutor {

    private CourseDAO coursedao;
    private LessonDAO lessondao;
    private ProfessorDAO professordao;
    private YearScheduleDAO yearscheduledao;
    private GroupDAO groupdao;
    private StudentDAO studentdao;
    private DayScheduleDAO dayscheduledao;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Autowired
    public LessonCommandExecutor(CourseDAO coursedao, StudentDAO studentdao,
            ProfessorDAO professordao, LessonDAO lessondao, DayScheduleDAO dayscheduledao,
            YearScheduleDAO yearscheduledao, GroupDAO groupdao) {
        this.coursedao = coursedao;
        this.lessondao = lessondao;
        this.professordao = professordao;
        this.dayscheduledao = dayscheduledao;
        this.yearscheduledao = yearscheduledao;
        this.studentdao = studentdao;
        this.groupdao = groupdao;
    }

    String getGroupsByLesson(String[] arguments) {
        String lessonIdStr = arguments[0];
        int lessonId = -1;
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong Lesson ID.";
        }
        Lesson lesson = null;
        try {
            lesson = lessondao.getById(lessonId);
        } catch (Exception e) {
            return "Could not find lesson.";
        }
        StringBuilder result = new StringBuilder();
        List<Group> groups = lessondao.getGroupsByLesson(groupdao, lesson);
        for (Group group : groups) {
            result.append(System.lineSeparator()).append(group.toString());
        }
        return result.toString();
    }

    String setLessonGroup(String[] arguments) {
        String lessonIdStr = arguments[0];
        int lessonId = -1;
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong Lesson ID.";
        }
        String groupIdStr = arguments[1];
        int groupId = -1;
        try {
            groupId = Integer.parseInt(groupIdStr);
        } catch (Exception e) {
            return "Wrong Group ID.";
        }
        boolean result = false;
        result = lessondao.setLessonGroup(lessondao.getById(lessonId),
                groupdao.getById(groupId));
        return result ? "success" : "failure";
    }

    String getLessonById(String[] arguments) {
        String lessonIdStr = arguments[0];
        int lessonId = -1;
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong Lesson ID.";
        }
        return lessondao.getById(lessonId).toString();
    }

    String createLesson(String[] arguments) {
        boolean result = false;
        String startTime = arguments[0];
        String endTime = arguments[1];
        String professorIdStr = arguments[2];
        int professorId = -1;
        try {
            professorId = Integer.parseInt(professorIdStr);
        } catch (Exception e) {
            return "Wrong Professor ID.";
        }
        Lesson lesson = new Lesson();
        lesson.setStartTime(LocalDateTime.parse(startTime, formatter));
        lesson.setEndTime(LocalDateTime.parse(endTime, formatter));
        lesson.setProfessor(professordao.getById(professorId));
        result = lessondao.create(lesson);
        return result ? "success" : "failure";
    }

    String deleteLesson(String[] arguments) {
        boolean result = false;
        String lessonIdStr = arguments[0];
        int lessonId = -1;
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong Professor ID.";
        }
        result = lessondao.delete(lessondao.getById(lessonId));
        return result ? "success" : "failure";
    }

    String updateLesson(String[] arguments) {
        boolean result = false;
        String startTime = arguments[0];
        String endTime = arguments[1];
        String professorIdStr = arguments[2];
        String lessonIdStr = arguments[3];
        int professorId = -1;
        int lessonId = -1;
        try {
            professorId = Integer.parseInt(professorIdStr);
        } catch (Exception e) {
            return "Wrong Professor ID.";
        }
        try {
            lessonId = Integer.parseInt(lessonIdStr);
        } catch (Exception e) {
            return "Wrong lesson ID.";
        }
        Lesson lesson = new Lesson();
        lesson.setStartTime(LocalDateTime.parse(startTime, formatter));
        lesson.setEndTime(LocalDateTime.parse(endTime, formatter));
        lesson.setProfessor(professordao.getById(professorId));
        result = lessondao.update(lessonId, lesson);
        return result ? "success" : "failure";
    }

    String getLessonIdList(String[] arguments) {
        StringBuilder result = new StringBuilder();
        List<Integer> ids = lessondao.getIdList();
        for (Integer id : ids) {
            result.append(String.valueOf(id)).append(System.lineSeparator());
        }
        return result.toString();
    }
}
