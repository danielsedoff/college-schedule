package com.danielsedoff.college.schedule.security.model;

public enum Permission {
    DATA_READ("data:read"), 
    DATA_WRITE("data:write");

    private final String permission;

    private Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
