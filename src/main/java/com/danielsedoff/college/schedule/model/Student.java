package com.danielsedoff.college.schedule.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person {
    
    @Column(name = "student_year")
    private int schoolYear;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student [person_id=" + person_id + ", name=" + name + ", schoolYear=" + schoolYear + ", group(Id only)="
                + group.getId() + "]";
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

}
