package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
public class Professor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "department_id")
    private int departmentId;
    @Column(name = "professor_name")
    private String name;
    @Column(name = "professor_notes")
    private String specialNotes;
    @Column(name = "professor_ranks")
    private String ranksTitles;

    public Professor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public String getRanksTitles() {
        return ranksTitles;
    }

    public void setRanksTitles(String ranksTitles) {
        this.ranksTitles = ranksTitles;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", departmentId=" + departmentId
                + ", name=" + name + ", specialNotes=" + specialNotes
                + ", ranksTitles=" + ranksTitles + "]";
    }

}
