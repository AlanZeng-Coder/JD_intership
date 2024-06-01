package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.dto.get.PickUpPointInfoDTO;
import com.example.springbootmybatisdemo.param.get.GetPickUpPointParam;
import com.example.springbootmybatisdemo.param.insert.PickUpPointParam;
import com.example.springbootmybatisdemo.service.PickUpPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pickUpPoints")
public class PickUpPointController {

    @Autowired
    private PickUpPointService pickUpPointService;

    @PostMapping("/create")
    public boolean createPickUpPoint(@RequestBody PickUpPointParam param) {
        return pickUpPointService.insertPickUpPoint(param);
    }

    @PostMapping("/getPickUpPoint")
    public ResponseEntity<PickUpPointInfoDTO> getPickUpPoint(@RequestBody GetPickUpPointParam param) {
        PickUpPointInfoDTO pickUpPointInfoDTO = pickUpPointService.getPickUpPoints(param);
        return ResponseEntity.ok(pickUpPointInfoDTO);
    }

}
