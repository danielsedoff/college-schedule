package com.danielsedoff.college.schedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_description")
    private String courseDescription;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Professor> professors = new ArrayList<Professor>();

    public Course() {
    }

    public int getId() {
        return courseId;
    }

//    public void setId(int id) {
//        this.course_id = id;
//    }

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

    public  List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessor(List<Professor> professor) {
        this.professors = professor;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

}
