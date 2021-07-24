package com.example.demo.model;

public class TodoForm {

    private String title;
    private Boolean completed;

    public TodoForm() {

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
