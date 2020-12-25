package com.danielsedoff.college.schedule.model;

public class PageLink {
    private String title;
    private String address;
    private String imageAddress;

    public PageLink(String title, String address, String imageAddress) {
        this.title = title;
        this.address = address;
        this.imageAddress = imageAddress;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getImageAddress() {
        return imageAddress;
    }

}
