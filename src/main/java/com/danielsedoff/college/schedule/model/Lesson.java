package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "lessons")
@ToString
@EqualsAndHashCode
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lesson_id;
    
    @Column(name = "start_time")
    private String startTime;
    
    @Column(name = "end_time")
    private String endTime;
    
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    
    @ManyToOne
    @JoinColumn(name = "dayschedule_id")
    private DaySchedule dayschedule;
    
    public Lesson() {
    }

    public int getId() {
        return lesson_id;
    }

    public void setId(int id) {
        this.lesson_id = id;
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public DaySchedule getDayschedule() {
        return dayschedule;
    }

    public void setDayschedule(DaySchedule dayschedule) {
        this.dayschedule = dayschedule;
    }
}
