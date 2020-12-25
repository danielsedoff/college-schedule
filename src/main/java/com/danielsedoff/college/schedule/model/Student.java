package com.danielsedoff.college.schedule.model;

import lombok.ToString;

@ToString
public class Student extends Person {
    private int schoolYear;
    
    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group;
}
