package com.danielsedoff.college.schedule.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int id;
    @Column(name = "date")
    private LocalDateTime day;
    @Column(name = "hasOverlaps")
    private boolean hasOverlaps;
    @OneToMany(mappedBy = "dayschedule")
    private List<Lesson> lessons;
    @Column(name = "yearschedule")
    public YearSchedule yearschedule;
    
    public DaySchedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public boolean getHasOverlaps() {
        return hasOverlaps;
    }

    public void setHasOverlaps(boolean hasOverlaps) {
        this.hasOverlaps = hasOverlaps;
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
