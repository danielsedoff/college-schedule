package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    
    @Column(name = "student_name")
    private String name;
    
    @Column(name = "student_year")
    private int schoolYear;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public int getStudent_id() {
        return student_id;
    }


    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }


    public Group getGroup() {
        return group;
    }


    public void setGroup(Group group) {
        this.group = group;
    }


    public Student() {

    }

    
    public int getId() {
        return student_id;
    }

    public void setId(int id) {
        this.student_id = id;
    }


    @Override
    public String toString() {
        return "Student [student_id=" + student_id + ", name=" + name
                + ", schoolYear=" + schoolYear + ", group=" + group.toString() + "]";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

}
