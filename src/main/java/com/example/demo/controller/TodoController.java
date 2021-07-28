package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;

import com.example.demo.http.request.TodoRequest;
import com.example.demo.http.response.HttpResponseError;
import com.example.demo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        try {
            return ResponseEntity.ok(todoService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponseError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoRequest request) {
        try {
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(new HttpResponseError(e.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponseError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoRequest request) {
        try {
            return new ResponseEntity<>(todoService.update(id, request), HttpStatus.ACCEPTED);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(new HttpResponseError(e.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponseError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(todoService.delete(id), HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(new HttpResponseError(e.getMessage()));
        } catch (Exception e) {
            return new ResponseEntity<>(new HttpResponseError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
