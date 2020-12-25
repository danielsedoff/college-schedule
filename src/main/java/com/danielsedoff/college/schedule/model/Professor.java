package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "professors")
public class Professor extends Person {

    @Column(name = "department_id")
    private int departmentId;
    
    @Column(name = "professor_notes")
    private String specialNotes;
    
    @Column(name = "professor_ranks")
    private String ranksTitles;

    public Professor() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        return "Professor [id=" + person_id + ", departmentId=" + departmentId + ", name=" + name + ", specialNotes="
                + specialNotes + ", ranksTitles=" + ranksTitles + "]";
    }

}
