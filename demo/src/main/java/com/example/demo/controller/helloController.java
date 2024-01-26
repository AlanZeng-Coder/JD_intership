package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController {
    @RequestMapping("/testHello")
    public String hello(){
        return "Hello Spring Boot! Work Done";
    }
}
