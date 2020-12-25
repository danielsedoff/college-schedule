package com.danielsedoff.college.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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

        switch (command) {
        case "getLessonIdList":
            return lessonCommandExecutor.getLessonIdList();
        case "updateLesson":
            return lessonCommandExecutor.updateLesson(arguments);
        case "deleteLesson":
            return lessonCommandExecutor.deleteLesson(arguments);
        case "createLesson":
            return lessonCommandExecutor.createLesson(arguments);
        case "getLessonById":
            return lessonCommandExecutor.getLessonById(arguments);
        case "setLessonGroup":
            return lessonCommandExecutor.setLessonGroup(arguments);
        case "getGroupsByLesson":
            return lessonCommandExecutor.getGroupsByLesson(arguments);
        case "getProfessorIdList":
            return professorCommandExecutor.getProfessorIdList();
        case "getProfessorById":
            return professorCommandExecutor.getProfessorById(arguments);
        case "deleteProfessor":
            return professorCommandExecutor.deleteProfessor(arguments);
        case "createProfessor":
            return professorCommandExecutor.createProfessor(arguments);
        case "updateProfessor":
            return professorCommandExecutor.updateProfessor(arguments);
        case "getCourseIdList":
            return courseCommandExecutor.getCourseIdList();
        case "createCourse":
            return courseCommandExecutor.createCourse(arguments);
        case "getCourseById":
            return courseCommandExecutor.getCourseById(arguments);
        case "removeCourse":
            return courseCommandExecutor.deleteCourse(arguments);
        case "updateCourse":
            return courseCommandExecutor.updateCourse(arguments);
        case "setCourseProfessors":
            return courseCommandExecutor.setCourseProfessors(arguments);
        case "getProfessorsByCourse":
            return courseCommandExecutor.getProfessorsByCourse(arguments);
        case "getDayscheduleIdList":
            return dayScheduleCommandExecutor.getDayscheduleIdList();
        case "createDaySchedule":
            return dayScheduleCommandExecutor.createDaySchedule(arguments);
        case "updateDaySchedule":
            return dayScheduleCommandExecutor.updateDaySchedule(arguments);
        case "deleteDaySchedule":
            return dayScheduleCommandExecutor.deleteDaySchedule(arguments);
        case "getDayScheduleById":
            return dayScheduleCommandExecutor.getDayScheduleById(arguments);
        case "setLessonDaySchedule":
            return dayScheduleCommandExecutor.setLessonDaySchedule(arguments);
        case "getLessonsByDaySchedule":
            return dayScheduleCommandExecutor.getLessonsByDaySchedule(arguments);
        case "getGroupIdList":
            return groupCommandExecutor.getGroupIdList();
        case "createGroup":
            return groupCommandExecutor.createGroup(arguments);
        case "updateGroup":
            return groupCommandExecutor.updateGroup(arguments);
        case "deleteGroup":
            return groupCommandExecutor.deleteGroup(arguments);
        case "getGroupById":
            return groupCommandExecutor.getGroupById(arguments);
        case "setGroupStudent":
            return groupCommandExecutor.setGroupStudent(arguments);
        case "getStudentsByGroup":
            return groupCommandExecutor.getStudentsByGroup(arguments);
        case "getStudentIdList":
            return studentCommandExecutor.getStudentIdList();
        case "createStudent":
            return studentCommandExecutor.createStudent(arguments);
        case "updateStudent":
            return studentCommandExecutor.updateStudent(arguments);
        case "deleteStudent":
            return studentCommandExecutor.deleteStudent(arguments);
        case "getStudentById":
            return studentCommandExecutor.getStudentById(arguments);
        case "getYearScheduleIdList":
            return yearScheduleCommandExecutor.getYearScheduleIdList();
        case "getYearScheduleById":
            return yearScheduleCommandExecutor.getYearScheduleById(arguments);
        case "createYearSchedule":
            return yearScheduleCommandExecutor.createYearSchedule(arguments);
        case "deleteYearSchedule":
            return yearScheduleCommandExecutor.deleteYearSchedule(arguments);
        case "updateYearSchedule":
            return yearScheduleCommandExecutor.updateYearSchedule(arguments);
        case "setDayScheduleYearSchedule":
            return yearScheduleCommandExecutor.setDayScheduleYearSchedule(arguments);
        case "getDayScheduleByYearSchedule":
            return yearScheduleCommandExecutor.getDayScheduleByYearSchedule(arguments);
        }

        return "No Such Command";
    }
}
