package com.danielsedoff.college.schedule.model;

import java.util.List;

public abstract class Person {
    private int id;
    private int departmentId;
    private String name;
    private List<String> specialNotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(List<String> specialNotes) {
        this.specialNotes = specialNotes;
    }
}
