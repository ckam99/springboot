package com.example.demo.http.request;

public class TodoRequest {
    private String title;
    private Boolean completed;

    public TodoRequest() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return this.completed;
    }
}
