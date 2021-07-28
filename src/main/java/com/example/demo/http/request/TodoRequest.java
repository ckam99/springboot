package com.example.demo.http.request;

public class TodoRequest {

    private String title;
    private Boolean completed;
    private Long userId;

    public TodoRequest() {
    }

    public TodoRequest(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public TodoRequest(String title, Boolean completed, Long userId) {
        this.title = title;
        this.completed = completed;
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isCompleted() {
        return this.completed;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
