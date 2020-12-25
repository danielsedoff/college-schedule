package com.danielsedoff.college.schedule.model;

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
@Table(name = "yearschedules")
@ToString
@EqualsAndHashCode
public class YearSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "year")
    private int year;
    @OneToMany(mappedBy = "yearschedule")
    private List<DaySchedule> dayschedules;

    public YearSchedule() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DaySchedule> getDayschedules() {
        return dayschedules;
    }

    public void setDayschedules(List<DaySchedule> dayschedules) {
        this.dayschedules = dayschedules;
    }
}
