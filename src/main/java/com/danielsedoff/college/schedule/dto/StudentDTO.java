package com.danielsedoff.college.schedule.dto;

public class StudentDTO {
    @Override
    public String toString() {
        return "StudentDTO [id=" + id + ", mode=" + mode + ", name=" + name + ", groupId=" + groupId
                + ", schoolYear=" + schoolYear + "]";
    }

    int id;
    String mode;
    String name;
    int groupId;
    int schoolYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }
}
