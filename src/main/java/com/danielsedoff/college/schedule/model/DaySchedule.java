package com.danielsedoff.college.schedule.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DaySchedule {
    private int id;
    private LocalDateTime day;
    private List<Lesson> lessons;
    private boolean hasOverlaps;
}
