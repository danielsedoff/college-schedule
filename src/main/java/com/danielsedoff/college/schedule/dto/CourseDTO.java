package com.danielsedoff.college.schedule.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class CourseDTO {
    String mode;

    @Min(-1)
    int id;
    
    
    @NotNull
    @Size(min = 2, max = 30)
    String name;
    
    @NotNull
    @Size(min = 2, max = 30)
    String description;
    
    int professorId;

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

    public int  getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professors) {
        this.professorId = professors;
    }
}
