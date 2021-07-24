package com.example.demo.model;

public class ResponseErrorModel {

    private final String error;

    public ResponseErrorModel(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}
