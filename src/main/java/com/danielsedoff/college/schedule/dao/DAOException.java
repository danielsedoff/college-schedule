package com.danielsedoff.college.schedule.dao;

public class DAOException extends Exception {
    private static final long serialVersionUID = -7426338758158922269L;

    public DAOException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
