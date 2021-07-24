package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.entity.Todo;
import com.example.demo.model.ResponseErrorModel;
import com.example.demo.model.TodoForm;
import com.example.demo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public List<Todo> getALL() {
        return service.getALL();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TodoForm todoForm) {
        try {
            return new ResponseEntity<>(service.create(todoForm), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseErrorModel(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TodoForm todoForm) {
        try {
            return new ResponseEntity<>(service.update(id, todoForm), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseErrorModel(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable long id) {
        try {
            Todo todo = service.findById(id);
            if (todo != null)
                return ResponseEntity.ok(todo);
            return new ResponseEntity<>(new ResponseErrorModel("Todo not found"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseErrorModel(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable long id) {
        try {
            return new ResponseEntity<>(service.remove(id), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseErrorModel(e.getMessage()));
        }
    }

}
