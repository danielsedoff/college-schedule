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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "yearschedules")
public class YearSchedule {
    public List<DaySchedule> getDayschedules() {
        return dayschedules;
    }

    public void setDayschedules(List<DaySchedule> dayschedules) {
        this.dayschedules = dayschedules;
    }

    @NotNull
    @Min(1)
    @Id
    @Column(name = "yearschedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int yearscheduleId;

    @NotNull
    @Min(1917)
    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "yearschedule", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
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
        return yearscheduleId;
    }

    public void setId(int id) {
        this.yearscheduleId = id;
    }
}
