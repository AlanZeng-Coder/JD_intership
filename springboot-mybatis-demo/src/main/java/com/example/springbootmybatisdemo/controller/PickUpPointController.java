package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.dto.get.PickUpPointInfoDTO;
import com.example.springbootmybatisdemo.param.delete.DeletePointParam;
import com.example.springbootmybatisdemo.param.get.GetPickUpPointParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import com.example.springbootmybatisdemo.param.set.SetPointParam;
import com.example.springbootmybatisdemo.service.PickUpPointService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pickUpPoints")
public class PickUpPointController {

    @Autowired
    private PickUpPointService pickUpPointService;

    @PostMapping("/createPickUpPoint")
    public boolean createPickUpPoint(@RequestBody PickUpPointParam param) {
        return pickUpPointService.createPickUpPoint(param);
    }

    @PostMapping("/getPickUpPoint")
    public ResponseEntity<PickUpPointInfoDTO> getPickUpPoint(@RequestBody GetPickUpPointParam param) {
        PickUpPointInfoDTO pickUpPointInfoDTO = pickUpPointService.getPickUpPoints(param);
        return ResponseEntity.ok(pickUpPointInfoDTO);
    }
    @PostMapping("/setPickUpPointStatus")
    public boolean setPickUpPointStatus(@RequestBody SetPointParam param){
        return pickUpPointService.setPickUpPointsStatus(param);
    }
    @PostMapping("/updatePickUpPointInfo")
    public boolean updatePickUpPointInfo(@RequestBody PickUpPointParam param){
        return pickUpPointService.updatePickPointInfo(param);
    }

    @DeleteMapping("/deletePickUpPoint")
    public boolean deletePickUpPoint(@RequestBody DeletePointParam param){
        return pickUpPointService.deletePickUpPoint(param);
    }
}
