package com.danielsedoff.college.schedule.dto;

import javax.validation.constraints.Min;

import com.danielsedoff.college.schedule.model.validation.LessonDateConstraint;

public class LessonDTO {

    String mode;

    @Min(-1)
    int id;

    @LessonDateConstraint
    String startTime;

    @LessonDateConstraint
    String endTime;

    @Min(1)
    int professorId;

    @Min(1)
    int groupId;

    private String professorName;
    
    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
