package com.danielsedoff.college.schedule.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Lesson {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Professor professor;
    private List<Group> groups;
}
