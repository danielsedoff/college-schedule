package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.ToString;

@ToString
public class YearSchedule {
    private int id;
    private int year;
    private List<DaySchedule> learningDays;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<DaySchedule> getLearningDays() {
        return learningDays;
    }

    public void setLearningDays(List<DaySchedule> learningDays) {
        this.learningDays = learningDays;
    }
    
    public int getId() {
        return id;
    }
}
