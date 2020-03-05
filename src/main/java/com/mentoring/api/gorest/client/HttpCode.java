package com.mentoring.api.gorest.client;

public enum HttpCode {

    OK(200, "OK"),
    Created(201, "Created"),
    Deleted(204, "Deleted"),
    NotFound(404, "Not_Found"),
    DataValidationFailed(422, "Data validation failed");

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
