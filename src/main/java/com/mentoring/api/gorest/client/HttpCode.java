package com.mentoring.api.gorest.client;

public enum HttpCode {

    OK(200, "OK"),
    Created(201, "Created"),
    Deleted(204, "Deleted"),
    NotFound(404, "Deleted");

    private int code;
    private String description;

    HttpCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}