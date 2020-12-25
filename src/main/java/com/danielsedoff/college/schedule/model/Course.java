package com.danielsedoff.college.schedule.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Course {
    private int id;
    private String name;
    private String courseDescription;
    private List<Professor> professors;

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

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
