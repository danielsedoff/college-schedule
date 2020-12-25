package com.danielsedoff.college.schedule.controller.rest;

public class RestPreconditions {
    public static <T> T checkFound(T resource) throws MyResourceNotFoundException {
        if (resource == null) {
            throw new MyResourceNotFoundException();
        }
        return resource;
    }
}