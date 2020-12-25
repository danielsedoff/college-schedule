package com.danielsedoff.college.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Student extends Person{
    private int schoolYear;
    private Group group;
}
