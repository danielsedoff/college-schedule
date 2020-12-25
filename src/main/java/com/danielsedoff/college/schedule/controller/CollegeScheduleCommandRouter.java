package com.danielsedoff.college.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class CollegeScheduleCommandRouter {
    private static final String ARGUMENT_DELIMITER = "|";
    private static final String[] AVAILABLE_COMMANDS = { "getCourseIdList",
            "createCourse", "getCourseById", "removeCourse", "updateCourse",
            "setCourseProfessors", "getProfessorsByCourse", "getDayscheduleIdList",
            "createDaySchedule", "updateDaySchedule", "deleteDaySchedule",
            "getDayScheduleById", "setLessonDaySchedule", "getLessonsByDaySchedule",
            "getGroupIdList", "createGroup", "updateGroup", "deleteGroup", "getGroupById",
            "setGroupStudent", "getStudentsByGroup", "getLessonIdList", "updateLesson",
            "deleteLesson", "createLesson", "getLessonById", "setLessonGroup",
            "getGroupsByLesson", "getProfessorIdList", "getProfessorById",
            "deleteProfessor", "createProfessor", "updateProfessor", "getStudentIdList",
            "createStudent", "updateStudent", "deleteStudent", "getStudentById",
            "getYearScheduleIdList", "getYearScheduleById", "createYearSchedule",
            "deleteYearSchedule", "updateYearSchedule", "setDayScheduleYearSchedule",
            "getDayScheduleByYearSchedule" };

    private LessonCommandExecutor lessonCommandExecutor;
    private ProfessorCommandExecutor professorCommandExecutor;
    private CourseCommandExecutor courseCommandExecutor;
    private DayScheduleCommandExecutor dayScheduleCommandExecutor;
    private GroupCommandExecutor groupCommandExecutor;
    private YearScheduleCommandExecutor yearScheduleCommandExecutor;
    private StudentCommandExecutor studentCommandExecutor;

    @Autowired
    public CollegeScheduleCommandRouter(LessonCommandExecutor lessonCommandExecutor,
            ProfessorCommandExecutor professorCommandExecutor,
            CourseCommandExecutor courseCommandExecutor,
            DayScheduleCommandExecutor dayScheduleCommandExecutor,
            GroupCommandExecutor groupCommandExecutor,
            YearScheduleCommandExecutor yearScheduleCommandExecutor,
            StudentCommandExecutor studentCommandExecutor) {
        this.lessonCommandExecutor = lessonCommandExecutor;
        this.professorCommandExecutor = professorCommandExecutor;
        this.studentCommandExecutor = studentCommandExecutor;
        this.courseCommandExecutor = courseCommandExecutor;
        this.dayScheduleCommandExecutor = dayScheduleCommandExecutor;
        this.groupCommandExecutor = groupCommandExecutor;
        this.yearScheduleCommandExecutor = yearScheduleCommandExecutor;
    }

    public String showAvailableCommands() {
        return String.join(", ", AVAILABLE_COMMANDS);
    }

    public String executeCommand(String command, String argumentsCombined) {
        String[] arguments = { "" };
        if (null != argumentsCombined) {
            arguments = argumentsCombined.split(ARGUMENT_DELIMITER);
        }
               if ("getLessonIdList".equals(command)) {
            return lessonCommandExecutor.getLessonIdList();
        } else if ("updateLesson".equals(command)) {
            return lessonCommandExecutor.updateLesson(arguments);
        } else if ("deleteLesson".equals(command)) {
            return lessonCommandExecutor.deleteLesson(arguments);
        } else if ("createLesson".equals(command)) {
            return lessonCommandExecutor.createLesson(arguments);
        } else if ("getLessonById".equals(command)) {
            return lessonCommandExecutor.getLessonById(arguments);
        } else if ("setLessonGroup".equals(command)) {
            return lessonCommandExecutor.setLessonGroup(arguments);
        } else if ("getGroupsByLesson".equals(command)) {
            return lessonCommandExecutor.getGroupsByLesson(arguments);
        } else if ("getProfessorIdList".equals(command)) {
            return professorCommandExecutor.getProfessorIdList();
        } else if ("getProfessorById".equals(command)) {
            return professorCommandExecutor.getProfessorById(arguments);
        } else if ("deleteProfessor".equals(command)) {
            return professorCommandExecutor.deleteProfessor(arguments);
        } else if ("createProfessor".equals(command)) {
            return professorCommandExecutor.createProfessor(arguments);
        } else if ("updateProfessor".equals(command)) {
            return professorCommandExecutor.updateProfessor(arguments);
        } else if ("getCourseIdList".equals(command)) {
            return courseCommandExecutor.getCourseIdList();
        } else if ("createCourse".equals(command)) {
            return courseCommandExecutor.createCourse(arguments);
        } else if ("getCourseById".equals(command)) {
            return courseCommandExecutor.getCourseById(arguments);
        } else if ("removeCourse".equals(command)) {
            return courseCommandExecutor.deleteCourse(arguments);
        } else if ("updateCourse".equals(command)) {
            return courseCommandExecutor.updateCourse(arguments);
        } else if ("setCourseProfessors".equals(command)) {
            return courseCommandExecutor.setCourseProfessors(arguments);
        } else if ("getProfessorsByCourse".equals(command)) {
            return courseCommandExecutor.getProfessorsByCourse(arguments);
        } else if ("getDayscheduleIdList".equals(command)) {
            return dayScheduleCommandExecutor.getDayscheduleIdList();
        } else if ("createDaySchedule".equals(command)) {
            return dayScheduleCommandExecutor.createDaySchedule(arguments);
        } else if ("updateDaySchedule".equals(command)) {
            return dayScheduleCommandExecutor.updateDaySchedule(arguments);
        } else if ("deleteDaySchedule".equals(command)) {
            return dayScheduleCommandExecutor.deleteDaySchedule(arguments);
        } else if ("getDayScheduleById".equals(command)) {
            return dayScheduleCommandExecutor.getDayScheduleById(arguments);
        } else if ("setLessonDaySchedule".equals(command)) {
            return dayScheduleCommandExecutor.setLessonDaySchedule(arguments);
        } else if ("getLessonsByDaySchedule".equals(command)) {
            return dayScheduleCommandExecutor.getLessonsByDaySchedule(arguments);
        } else if ("getGroupIdList".equals(command)) {
            return groupCommandExecutor.getGroupIdList();
        } else if ("createGroup".equals(command)) {
            return groupCommandExecutor.createGroup(arguments);
        } else if ("updateGroup".equals(command)) {
            return groupCommandExecutor.updateGroup(arguments);
        } else if ("deleteGroup".equals(command)) {
            return groupCommandExecutor.deleteGroup(arguments);
        } else if ("getGroupById".equals(command)) {
            return groupCommandExecutor.getGroupById(arguments);
        } else if ("setGroupStudent".equals(command)) {
            return groupCommandExecutor.setGroupStudent(arguments);
        } else if ("getStudentsByGroup".equals(command)) {
            return groupCommandExecutor.getStudentsByGroup(arguments);
        } else if ("getStudentIdList".equals(command)) {
            return studentCommandExecutor.getStudentIdList();
        } else if ("createStudent".equals(command)) {
            return studentCommandExecutor.createStudent(arguments);
        } else if ("updateStudent".equals(command)) {
            return studentCommandExecutor.updateStudent(arguments);
        } else if ("deleteStudent".equals(command)) {
            return studentCommandExecutor.deleteStudent(arguments);
        } else if ("getStudentById".equals(command)) {
            return studentCommandExecutor.getStudentById(arguments);
        } else if ("getYearScheduleIdList".equals(command)) {
            return yearScheduleCommandExecutor.getYearScheduleIdList();
        } else if ("getYearScheduleById".equals(command)) {
            return yearScheduleCommandExecutor.getYearScheduleById(arguments);
        } else if ("createYearSchedule".equals(command)) {
            return yearScheduleCommandExecutor.createYearSchedule(arguments);
        } else if ("deleteYearSchedule".equals(command)) {
            return yearScheduleCommandExecutor.deleteYearSchedule(arguments);
        } else if ("updateYearSchedule".equals(command)) {
            return yearScheduleCommandExecutor.updateYearSchedule(arguments);
        } else if ("setDayScheduleYearSchedule".equals(command)) {
            return yearScheduleCommandExecutor.setDayScheduleYearSchedule(arguments);
        } else if ("getDayScheduleByYearSchedule".equals(command)) {
            return yearScheduleCommandExecutor.getDayScheduleByYearSchedule(arguments);
        }

        return "No Such Command";
    }
}
