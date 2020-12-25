package com.danielsedoff.college.schedule.controller;

import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import com.danielsedoff.college.schedule.dao.CourseDAO;
import com.danielsedoff.college.schedule.dao.DayScheduleDAO;
import com.danielsedoff.college.schedule.dao.GroupDAO;
import com.danielsedoff.college.schedule.dao.LessonDAO;
import com.danielsedoff.college.schedule.dao.ProfessorDAO;
import com.danielsedoff.college.schedule.dao.StudentDAO;
import com.danielsedoff.college.schedule.dao.YearScheduleDAO;

public class CollegeScheduleCommandRouter {
    private static final String ARGUMENT_DELIMITER = "|";
    private static final String AVAILABLE_COMMANDS = 
              "getCourseIdList, createCourse, getCourseById, "
            + "removeCourse, updateCourse, "
            + "setCourseProfessors, getProfessorsByCourse, "
            + "getDayscheduleIdList, createDaySchedule, updateDaySchedule, deleteDaySchedule, "
            + "getDayScheduleById, setLessonDaySchedule, getLessonsByDaySchedule, "
            + "getGroupIdList, createGroup, updateGroup, deleteGroup, getGroupById, "
            + "setGroupStudent, getStudentsByGroup, "
            + "getLessonIdList, updateLesson, deleteLesson, createLesson, getLessonById, "
            + "setLessonGroup, getGroupsByLesson"
            + "getProfessorIdList, getProfessorById, deleteProfessor, createProfessor, "
            + "updateProfessor, "
            + "getStudentIdList, createStudent, updateStudent, deleteStudent, getStudentById, "
            + "getYearScheduleIdList, getYearScheduleById, createYearSchedule, deleteYearSchedule, "
            + "updateYearSchedule, setDayScheduleYearSchedule, getDayScheduleByYearSchedule, ";

    private CourseDAO coursedao;
    private LessonDAO lessondao;
    private ProfessorDAO professordao;
    private YearScheduleDAO yearscheduledao;
    private GroupDAO groupdao;
    private StudentDAO studentdao;
    private DayScheduleDAO dayscheduledao;
    private LessonCommandExecutor lessonCommandExecutor;
    private ProfessorCommandExecutor professorCommandExecutor;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private CourseCommandExecutor courseCommandExecutor;
    private DayScheduleCommandExecutor dayScheduleCommandExecutor;
    private GroupCommandExecutor groupCommandExecutor;
    private YearScheduleCommandExecutor yearScheduleCommandExecutor;
    private StudentCommandExecutor studentCommandExecutor;

    @Autowired
    public CollegeScheduleCommandRouter(CourseDAO coursedao, StudentDAO studentdao,
            ProfessorDAO professordao, LessonDAO lessondao, DayScheduleDAO dayscheduledao,
            YearScheduleDAO yearscheduledao, GroupDAO groupdao,
            LessonCommandExecutor lessonCommandExecutor,
            ProfessorCommandExecutor professorCommandExecutor, CourseCommandExecutor courseCommandExecutor,
            DayScheduleCommandExecutor dayScheduleCommandExecutor, GroupCommandExecutor groupCommandExecutor,
            YearScheduleCommandExecutor yearScheduleCommandExecutor, StudentCommandExecutor studentCommandExecutor
            ) {
        this.coursedao = coursedao;
        this.lessondao = lessondao;
        this.professordao = professordao;
        this.dayscheduledao = dayscheduledao;
        this.yearscheduledao = yearscheduledao;
        this.studentdao = studentdao;
        this.groupdao = groupdao;
        this.lessonCommandExecutor = lessonCommandExecutor;
        this.professorCommandExecutor = professorCommandExecutor;
        this.studentCommandExecutor = studentCommandExecutor;
        this.courseCommandExecutor = courseCommandExecutor;
        this.dayScheduleCommandExecutor = dayScheduleCommandExecutor;
        this.groupCommandExecutor = groupCommandExecutor;
        this.yearScheduleCommandExecutor = yearScheduleCommandExecutor;
    }

    public String showAvailableCommands() {
        return AVAILABLE_COMMANDS;
    }

    public String executeCommand(String command, String argumentsCombined) {
        String[] arguments = { "" };
        if (null != argumentsCombined) {
            arguments = argumentsCombined.split(ARGUMENT_DELIMITER);
        }
        
        if ("getLessonIdList".equals(command))
            return lessonCommandExecutor.getLessonIdList(arguments);
        if ("updateLesson".equals(command))
            return lessonCommandExecutor.updateLesson(arguments);
        if ("deleteLesson".equals(command))
            return lessonCommandExecutor.deleteLesson(arguments);
        if ("createLesson".equals(command))
            return lessonCommandExecutor.createLesson(arguments);
        if ("getLessonById".equals(command))
            return lessonCommandExecutor.getLessonById(arguments);
        if ("setLessonGroup".equals(command))
            return lessonCommandExecutor.setLessonGroup(arguments);
        if ("getGroupsByLesson".equals(command))
            return lessonCommandExecutor.getGroupsByLesson(arguments);

        if ("getProfessorIdList".equals(command))
            return professorCommandExecutor.getProfessorIdList(arguments);
        if ("getProfessorById".equals(command))
            return professorCommandExecutor.getProfessorById(arguments);
        if ("deleteProfessor".equals(command))
            return professorCommandExecutor.deleteProfessor(arguments);
        if ("createProfessor".equals(command))
            return professorCommandExecutor.createProfessor(arguments);
        if ("updateProfessor".equals(command))
            return professorCommandExecutor.updateProfessor(arguments);
        
        if ("getCourseIdList".equals(command))
            return courseCommandExecutor.getCourseIdList(arguments);
        if ("createCourse".equals(command))
            return courseCommandExecutor.createCourse(arguments);
        if ("getCourseById".equals(command))
            return courseCommandExecutor.getCourseById(arguments);
        if ("removeCourse".equals(command))
            return courseCommandExecutor.removeCourse(arguments);
        if ("updateCourse".equals(command))
            return courseCommandExecutor.updateCourse(arguments);
        if ("setCourseProfessors".equals(command))
            return courseCommandExecutor.setCourseProfessors(arguments);
        if ("getProfessorsByCourse".equals(command))
            return courseCommandExecutor.getProfessorsByCourse(arguments);
        
        if ("getDayscheduleIdList".equals(command))
            return dayScheduleCommandExecutor.getDayscheduleIdList(arguments);
        if ("createDaySchedule".equals(command))
            return dayScheduleCommandExecutor.createDaySchedule(arguments);
        if ("updateDaySchedule".equals(command))
            return dayScheduleCommandExecutor.updateDaySchedule(arguments);
        if ("deleteDaySchedule".equals(command))
            return dayScheduleCommandExecutor.deleteDaySchedule(arguments);
        if ("getDayScheduleById".equals(command))
            return dayScheduleCommandExecutor.getDayScheduleById(arguments);
        if ("setLessonDaySchedule".equals(command))
            return dayScheduleCommandExecutor.setLessonDaySchedule(arguments);
        if ("getLessonsByDaySchedule".equals(command))
            return dayScheduleCommandExecutor.getLessonsByDaySchedule(arguments);

        if ("getGroupIdList".equals(command))
            return groupCommandExecutor.getGroupIdList(arguments);
        if ("createGroup".equals(command))
            return groupCommandExecutor.createGroup(arguments);
        if ("updateGroup".equals(command))
            return groupCommandExecutor.updateGroup(arguments);
        if ("deleteGroup".equals(command))
            return groupCommandExecutor.deleteGroup(arguments);
        if ("getGroupById".equals(command))
            return groupCommandExecutor.getGroupById(arguments);
        if ("setGroupStudent".equals(command))
            return groupCommandExecutor.setGroupStudent(arguments);
        if ("getStudentsByGroup".equals(command))
            return groupCommandExecutor.getStudentsByGroup(arguments);

        if ("getStudentIdList".equals(command))
            return studentCommandExecutor.getStudentIdList(arguments);
        if ("createStudent".equals(command))
            return studentCommandExecutor.createStudent(arguments);
        if ("updateStudent".equals(command))
            return studentCommandExecutor.updateStudent(arguments);
        if ("deleteStudent".equals(command))
            return studentCommandExecutor.deleteStudent(arguments);
        if ("getStudentById".equals(command))
            return studentCommandExecutor.getStudentById(arguments);

        if ("getYearScheduleIdList".equals(command))
            return yearScheduleCommandExecutor.getYearScheduleIdList(arguments);
        if ("getYearScheduleById".equals(command))
            return yearScheduleCommandExecutor.getYearScheduleById(arguments);
        if ("createYearSchedule".equals(command))
            return yearScheduleCommandExecutor.createYearSchedule(arguments);
        if ("deleteYearSchedule".equals(command))
            return yearScheduleCommandExecutor.deleteYearSchedule(arguments);
        if ("updateYearSchedule".equals(command))
            return yearScheduleCommandExecutor.updateYearSchedule(arguments);
        if ("setDayScheduleYearSchedule".equals(command))
            return yearScheduleCommandExecutor.setDayScheduleYearSchedule(arguments);
        if ("getDayScheduleByYearSchedule".equals(command))
            return yearScheduleCommandExecutor.getDayScheduleByYearSchedule(arguments);
        
        return "No Such Command";
    }
}
