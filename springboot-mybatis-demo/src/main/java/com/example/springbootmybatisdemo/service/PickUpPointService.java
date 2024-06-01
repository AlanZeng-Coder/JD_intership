package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.dto.PickUpPointParam;
import com.example.springbootmybatisdemo.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PickUpPointService {

    @Autowired
    private PickUpPointMapper pickUpPointMapper;

    public boolean insertPickUpPoint(PickUpPointParam param) {
        if(param.getUser().equals("AlanZeng")){
            return false;
        }else{
            return pickUpPointMapper.insertPickUpPoint(param) > 0;
        }

    }
}
