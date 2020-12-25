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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "yearschedules")
@ToString
@EqualsAndHashCode
public class YearSchedule {
    public List<DaySchedule> getDayschedules() {
        return dayschedules;
    }

    public void setDayschedules(List<DaySchedule> dayschedules) {
        this.dayschedules = dayschedules;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int yearschedule_id;
    
    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "yearschedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DaySchedule> dayschedules = new ArrayList<>();
    
    public YearSchedule() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return yearschedule_id;
    }

    public void setId(int id) {
        this.yearschedule_id = id;
    }
}
