package com.danielsedoff.college.schedule.dto;

public class ProfessorDTO {
    @Override
    public String toString() {
        return "ProfessorDTO [id=" + id + ", mode=" + mode + ", name=" + name + ", ranks=" + ranks
                + ", notes=" + notes + ", departmentId=" + departmentId + "]";
    }

    int id;
    String mode;
    String name;
    String ranks;
    String notes;
    int departmentId;

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

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

}
