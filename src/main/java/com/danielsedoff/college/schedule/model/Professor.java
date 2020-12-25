package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Professor extends Person {
    private List<String> ranksTitles;
}
