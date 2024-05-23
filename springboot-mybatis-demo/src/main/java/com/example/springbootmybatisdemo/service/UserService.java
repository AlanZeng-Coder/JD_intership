package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.mapper.UserMapper;
import com.example.springbootmybatisdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
    public User findById(Long id){
        return userMapper.findById(id);
    }
    public void insert(User user){
        userMapper.insert(user);
    }
    public void update(User user){
        userMapper.update(user);
    }
    public void delete(Long id){
        userMapper.delete(id);
    }
}
