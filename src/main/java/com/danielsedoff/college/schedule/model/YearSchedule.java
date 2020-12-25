package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class YearSchedule {
    private int year;
    private List<DaySchedule> learningDays;
}
