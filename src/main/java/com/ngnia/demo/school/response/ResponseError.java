package com.ngnia.demo.school.response;

public class ResponseError {

    private final String message;

    public ResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
