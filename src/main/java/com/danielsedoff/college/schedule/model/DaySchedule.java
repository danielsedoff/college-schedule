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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "dayschedules")
@ToString
@EqualsAndHashCode
public class DaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayschedule_id;
    
    @Column(name = "the_day")
    private String day;
    
    @Column(name = "hasOverlaps")
    private boolean hasOverlaps;

    @OneToMany(mappedBy = "dayschedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<Lesson>();
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "yearschedule_id")
    private YearSchedule yearschedule;
    
    public DaySchedule() {
    }

    public int getId() {
        return dayschedule_id;
    }

    public void setId(int id) {
        this.dayschedule_id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean getHasOverlaps() {
        return hasOverlaps;
    }

    public void setHasOverlaps(boolean hasOverlaps) {
        this.hasOverlaps = hasOverlaps;
    }

    public int getDayschedule_id() {
        return dayschedule_id;
    }

    public void setDayschedule_id(int dayschedule_id) {
        this.dayschedule_id = dayschedule_id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public YearSchedule getYearschedule() {
        return yearschedule;
    }

    public void setYearschedule(YearSchedule yearschedule) {
        this.yearschedule = yearschedule;
    }
}
