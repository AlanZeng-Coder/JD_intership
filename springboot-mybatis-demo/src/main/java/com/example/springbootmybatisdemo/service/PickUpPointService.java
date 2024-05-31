package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.dto.CreatePickUpPointParam;
import com.example.springbootmybatisdemo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickUpPointService {

    @Autowired
    private PickUpPointMapper pickUpPointMapper;

    public boolean insertPickUpPoint(CreatePickUpPointParam param) {
        return pickUpPointMapper.insertPickUpPoint(param) > 0;
    }
}
