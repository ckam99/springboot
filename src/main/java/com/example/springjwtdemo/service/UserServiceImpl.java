package com.example.springjwtdemo.service;

import java.util.Arrays;
import java.util.List;

import com.example.springjwtdemo.domain.Role;
import com.example.springjwtdemo.domain.User;
import com.example.springjwtdemo.repository.RoleRepository;
import com.example.springjwtdemo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} in database", user.getEmail());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} in database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("adding role {} to user {}", roleName, email);
        User user = userRepo.findByEmail(email);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String email) {
        log.info("Fetching user {}", email);
        return userRepo.findByEmail(email);
    }

    @Override
    public User getUser(Long id) {
        log.info("Fetching user by id {}", id);
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all user");
        return userRepo.findAll();
    }

}
