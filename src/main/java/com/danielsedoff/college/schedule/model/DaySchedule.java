package com.danielsedoff.college.schedule.model;

import java.time.LocalDateTime;
import java.util.List;

public class DaySchedule {
    private int id;
    private LocalDateTime day;
    private List<Lesson> lessons;
    private boolean hasOverlaps;

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public boolean getHasOverlaps() {
        return hasOverlaps;
    }

    public void setHasOverlaps(boolean hasOverlaps) {
        this.hasOverlaps = hasOverlaps;
    }
}
