package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int yearschedule_id;
    @Column(name = "year")
    private int year;

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
