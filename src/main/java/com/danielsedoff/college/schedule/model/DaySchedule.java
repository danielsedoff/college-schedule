package com.danielsedoff.college.schedule.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dayschedules")
public class DaySchedule {

    @NotNull
    @Min(-1)
    @Id
    @Column(name = "dayschedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayscheduleId;
    
    @NotNull
    @Size(min=2, max=30)
    @Column(name = "the_day")
    private String day;
    
    @Column(name = "hasoverlaps")
    private boolean hasOverlaps;

    @OneToMany(mappedBy = "dayschedule") //, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<Lesson>();
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "yearschedule_id")
    private YearSchedule yearschedule;
    
    public DaySchedule() {
    }

    public int getId() {
        return dayscheduleId;
    }

    public void setId(int id) {
        this.dayscheduleId = id;
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

    public int getDayscheduleId() {
        return dayscheduleId;
    }

    public void setDayscheduleId(int dayscheduleId) {
        this.dayscheduleId = dayscheduleId;
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
