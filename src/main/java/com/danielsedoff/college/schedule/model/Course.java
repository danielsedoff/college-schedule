package com.danielsedoff.college.schedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course {

    @Min(-1)
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Size(min = 2, max = 30)
    @Column(name = "course_name")
    private String name;

    @Size(min = 2, max = 30)
    @Column(name = "course_description")
    private String courseDescription;

    @OneToMany(mappedBy = "course")
    private List<Professor> professors = new ArrayList<Professor>();

    public Course() {
    }

    public int getId() {
        return courseId;
    }

    public void setId(int id) {
        this.courseId = id;
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

    public void setProfessor(List<Professor> professor) {
        this.professors = professor;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

}
