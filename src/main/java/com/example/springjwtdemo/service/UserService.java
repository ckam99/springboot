package com.example.springjwtdemo.service;

import java.util.List;

import com.example.springjwtdemo.domain.Role;
import com.example.springjwtdemo.domain.User;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);

    User getUser(String email);

    User getUser(Long id);

    List<User> getUsers();
}
