package com.example.springjwtdemo.controller;

import com.example.springjwtdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

}
