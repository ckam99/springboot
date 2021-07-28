package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.example.demo.entity.User;
import com.example.demo.http.exception.EntityAlreadyExistException;
import com.example.demo.http.request.UserUpdateRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID does not exists!"));
    }

    public User findByEmail(String email) {
        User user = repository.findByEmail(email);
        if (user != null)
            return user;
        throw new EntityNotFoundException("User with ID does not exists!");
    }

    public User register(User newUser) throws EntityAlreadyExistException {
        if (repository.findByEmail(newUser.getEmail()) != null)
            throw new EntityAlreadyExistException("User with email already exist");
        return repository.save(newUser);
    }

    public User update(long id, UserUpdateRequest payload) {
        User user = this.findById(id);
        user.setName(payload.getName());
        return repository.save(user);
    }

    public Boolean remove(long id) {
        User user = this.findById(id);
        repository.delete(user);
        return true;
    }

}