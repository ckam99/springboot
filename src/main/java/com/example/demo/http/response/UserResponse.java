package com.example.demo.http.response;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.Todo;
import com.example.demo.entity.User;

public class UserResponse {

    private Long id;
    private String email;
    private String name;

    private List<Todo> todos;

    public UserResponse() {
    }

    public UserResponse(Long id, String email, String name, List<Todo> todos) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.todos = todos;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.todos = user.getTodos();
        // this.todos = user.getTodos().stream().map(user).collect(Collectors.toList());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return this.todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

}
