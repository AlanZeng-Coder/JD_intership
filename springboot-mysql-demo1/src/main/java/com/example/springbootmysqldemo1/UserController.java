package com.example.springbootmysqldemo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @PostMapping("/users")
    public int createUser(@RequestBody User user) {
        return userDAO.save(user);
    }
}