package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", completed='" + isCompleted() + "'"
                + ", user='" + getUser() + "'" + "}";
    }

}
