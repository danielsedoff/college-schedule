package com.danielsedoff.college.schedule.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.danielsedoff.college.schedule.model.validation.LessonDateConstraint;

@Entity
@Table(name = "lessons")
public class Lesson {
    
    @Min(-1)
    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lessonId;

    @LessonDateConstraint
    @Column(name = "start_time")
    private String startTime;

    @LessonDateConstraint
    @Column(name = "end_time")
    private String endTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dayschedule_id")
    private DaySchedule dayschedule;

    public Lesson() {
    }

    public int getId() {
        return lessonId;
    }

    public void setId(int id) {
        this.lessonId = id;
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
