package com.danielsedoff.college.schedule.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "date")
    private LocalDateTime day;
    @Column(name = "hasOverlaps")
    private boolean hasOverlaps;

    public DaySchedule() {
    }

    public int getId() {
        return dayschedule_id;
    }

    public void setId(int id) {
        this.dayschedule_id = id;
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
}
