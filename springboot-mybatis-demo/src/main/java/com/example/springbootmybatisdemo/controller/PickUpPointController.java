package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.dto.CreatePickUpPointParam;
import com.example.springbootmybatisdemo.service.PickUpPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pickUpPoints")
public class PickUpPointController {

    @Autowired
    private PickUpPointService pickUpPointService;

    @PostMapping("/create")
    public boolean createPickUpPoint(@RequestBody CreatePickUpPointParam param) {
        return pickUpPointService.insertPickUpPoint(param);
    }

}
