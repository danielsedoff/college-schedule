package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Group {
    private int id;
    private int departmentId;
    private List<Student> studentList;
    private List<String> specialNotes;
}
