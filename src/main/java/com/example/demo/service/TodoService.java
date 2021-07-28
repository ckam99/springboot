package com.example.demo.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.example.demo.entity.Todo;
import com.example.demo.entity.User;
import com.example.demo.http.request.TodoRequest;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoService {

    @Autowired
    TodoRepository repository;

    @Autowired
    UserService userService;

    public List<Todo> getAll() {
        return repository.findAll();
    }

    public Todo create(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        if (request.getUserId() != null) {
            todo.setUser(userService.findById(request.getUserId()));
        }
        return repository.save(todo);
    }

    public Todo getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Todo id %s with not found", id)));
    }

    public Todo update(Long id, TodoRequest request) {
        Todo todo = getById(id);
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.getCompleted());
        return repository.save(todo);
    }

    public Boolean delete(Long id) {
        repository.delete(getById(id));
        return true;
    }

}
