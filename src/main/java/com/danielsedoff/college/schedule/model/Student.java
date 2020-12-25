package com.danielsedoff.college.schedule.model;

import lombok.ToString;

@ToString
public class Student extends Person {
    private int schoolYear;

    private int groupId;

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
