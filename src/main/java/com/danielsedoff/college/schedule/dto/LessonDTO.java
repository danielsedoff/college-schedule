package com.danielsedoff.college.schedule.dto;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.danielsedoff.college.schedule.model.Group;
import com.danielsedoff.college.schedule.model.Professor;

@ToString
@EqualsAndHashCode
public class LessonDTO {
    String mode;
    int id;
    String startTime;
    String endTime;
    List<Professor> professors;
    List<Group> groups;

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

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
