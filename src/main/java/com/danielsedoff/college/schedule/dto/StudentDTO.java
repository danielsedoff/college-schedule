package com.danielsedoff.college.schedule.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class StudentDTO {
    @Override
    public String toString() {
        return "StudentDTO [id=" + id + ", mode=" + mode + ", name=" + name + ", groupId=" + groupId + ", schoolYear="
                + schoolYear + "]";
    }

    @Min(-1)
    int id;

    String mode;

    @Size(min = 2, max = 30)
    String name;

    @Min(1)
    int groupId;

    @Min(1)
    @Max(6)
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
