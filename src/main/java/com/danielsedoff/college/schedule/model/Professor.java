package com.danielsedoff.college.schedule.model;

import java.util.List;
import lombok.ToString;

@ToString
public class Professor extends Person {
    private List<String> ranksTitles;

    public List<String> getRanksTitles() {
        return ranksTitles;
    }

    public void setRanksTitles(List<String> ranksTitles) {
        this.ranksTitles = ranksTitles;
    }
}
