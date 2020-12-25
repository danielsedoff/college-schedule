package com.danielsedoff.college.schedule.model;

public class PageLink {
    private String title;
    private String address;

    public PageLink(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

}
