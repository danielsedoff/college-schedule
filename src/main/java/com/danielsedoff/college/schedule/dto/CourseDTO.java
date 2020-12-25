package com.danielsedoff.college.schedule.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.danielsedoff.college.schedule.model.Professor;

@Component
public class CourseDTO {
    String mode;
    int id;
    String name;
    String description;
    List<Professor> professors;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Professor>  getProfessorId() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
