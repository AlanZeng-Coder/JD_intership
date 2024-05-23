package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.model.User;
import com.example.springbootmybatisdemo.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private ObjectMapper objectMapper;

    public List<User> findAll() {
        try (Jedis jedis = jedisPool.getResource()) {
            String usersCache = jedis.get("users");
            if (usersCache != null) {
                return deserializeUsers(usersCache);
            } else {
                List<User> users = userMapper.findAll();
                jedis.set("users", serializeUsers(users));
                return users;
            }
        }
    }

    public User findById(Long id) {
        try (Jedis jedis = jedisPool.getResource()) {
            String userCache = jedis.get("user:" + id);
            if (userCache != null) {
                return deserializeUser(userCache);
            } else {
                User user = userMapper.findById(id);
                if (user != null) {
                    jedis.set("user:" + id, serializeUser(user));
                }
                return user;
            }
        }
    }

    public void insert(User user) {
        userMapper.insert(user);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del("users");
        }
    }

    public void update(User user) {
        userMapper.update(user);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del("users");
            jedis.set("user:" + user.getId(), serializeUser(user));
        }
    }

    public void delete(Long id) {
        userMapper.delete(id);
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del("users");
            jedis.del("user:" + id);
        }
    }

    private String serializeUsers(List<User> users) {
        try {
            return objectMapper.writeValueAsString(users);
        } catch (Exception e) {
            throw new RuntimeException("序列化用户数据失败", e);
        }
    }

    private List<User> deserializeUsers(String usersCache) {
        try {
            return objectMapper.readValue(usersCache, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class));
        } catch (Exception e) {
            throw new RuntimeException("反序列化用户数据失败", e);
        }
    }

    private String serializeUser(User user) {
        try {
            return objectMapper.writeValueAsString(user);
        } catch (Exception e) {
            throw new RuntimeException("序列化用户数据失败", e);
        }
    }

    private User deserializeUser(String userCache) {
        try {
            return objectMapper.readValue(userCache, User.class);
        } catch (Exception e) {
            throw new RuntimeException("反序列化用户数据失败", e);
        }
    }
}