package com.danielsedoff.college.schedule.dto;

import org.springframework.stereotype.Component;

@Component
public class CourseDTO {
    String mode;
    int id;
    String name;
    String description;
    int connectedId1;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getConnectedId1() {
        return connectedId1;
    }

    public void setConnectedId1(int connectedId1) {
        this.connectedId1 = connectedId1;
    }
}
