package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Person {
    private int id;
    private int departmentId;
    private String name;
    private List<String> specialNotes;
}
