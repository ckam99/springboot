package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.entity.Todo;
import com.example.demo.model.TodoForm;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final AtomicLong counter = new AtomicLong();

    List<Todo> todos = new ArrayList<Todo>(Arrays.asList(new Todo(counter.incrementAndGet(), "Java", false),
            new Todo(counter.incrementAndGet(), "Python", true),
            new Todo(counter.incrementAndGet(), "Javascript", false),
            new Todo(counter.incrementAndGet(), "PHP", false)));

    public List<Todo> getALL() {
        return todos;
    }

    public Todo create(TodoForm todoForm) {
        Todo todo = new Todo(counter.incrementAndGet(), todoForm.getTitle(), false);
        todos.add(todo);
        return todo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public Todo update(long id, TodoForm todoForm) {
        Todo todo = this.findById(id);
        if (todo.getTitle() != null) {
            if (todoForm.getTitle() != null)
                todo.setTitle(todoForm.getTitle());
            if (todoForm.getCompleted() != null)
                todo.setCompleted(todoForm.getCompleted());
        }
        return todo;
    }

    public Boolean remove(long id) {
        Todo todo = this.findById(id);
        if (todo != null) {
            todos.remove(todo);
            return true;
        }
        return false;
    }
}
