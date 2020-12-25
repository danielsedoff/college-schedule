package com.danielsedoff.college.schedule.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProfessorDTO {
    @Override
    public String toString() {
        return "ProfessorDTO [id=" + id + ", mode=" + mode + ", name=" + name + ", ranks=" + ranks + ", notes=" + notes
                + "]";
    }

    @NotNull
    @Min(-1)
    int id;

    String mode;

    @NotNull
    @Size(min = 2, max = 30)
    String name;

    @NotNull
    @Size(min = 2, max = 30)
    String ranks;

    @NotNull
    @Size(min = 2, max = 30)
    String notes;

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

}
