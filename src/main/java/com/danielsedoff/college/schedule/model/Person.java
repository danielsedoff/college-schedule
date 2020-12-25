package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person {

    @NotNull
    @Min(-1)
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int personId;

    public int getId() {
        return personId;
    }

    public void setId(int id) {
        this.personId = id;
    }

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "person_name")
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
