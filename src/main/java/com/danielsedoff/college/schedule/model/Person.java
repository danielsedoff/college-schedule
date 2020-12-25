package com.danielsedoff.college.schedule.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int person_id;
    
    public int getId() {
        return person_id;
    }

//    public void setId(int id) {
//        this.person_id = id;
//    }

    @Column(name = "person_name")
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
