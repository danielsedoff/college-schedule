package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Course {
    private int id;
    private String name;
    private String courseDescription;
    private List<Professor> professors;
}
