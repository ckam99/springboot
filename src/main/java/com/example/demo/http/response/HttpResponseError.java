package com.example.demo.http.response;

public class HttpResponseError {
    private final String message;

    public HttpResponseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
