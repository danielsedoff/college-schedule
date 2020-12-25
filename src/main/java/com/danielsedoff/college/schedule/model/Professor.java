package com.danielsedoff.college.schedule.model;

import lombok.ToString;

@ToString
public class Professor extends Person {
    private String ranksTitles;

    public String getRanksTitles() {
        return ranksTitles;
    }

    public void setRanksTitles(String ranksTitles) {
        this.ranksTitles = ranksTitles;
    }
}
