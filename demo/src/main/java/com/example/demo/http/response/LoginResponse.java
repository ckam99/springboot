package com.example.demo.http.response;

public class LoginResponse {

    private final String accessToken;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    @Override
    public String toString() {
        return "{" + " accessToken='" + getAccessToken() + "'" + "}";
    }

}
