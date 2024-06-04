package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.dto.Response;
import com.example.springbootmybatisdemo.dto.get.PickUpPointDTO;
import com.example.springbootmybatisdemo.dto.get.PickUpPointInfoDTO;
import com.example.springbootmybatisdemo.param.delete.DeletePointParam;
import com.example.springbootmybatisdemo.param.get.GetPickUpPointParam;
import com.example.springbootmybatisdemo.param.get.GetPointByStoreIdParam;
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
    public Response<Boolean> createPickUpPoint(@RequestBody PickUpPointParam param) {
        return pickUpPointService.createPickUpPoint(param);
    }

    @PostMapping("/getPickUpPoint")
    public Response<PickUpPointInfoDTO> getPickUpPoint(@RequestBody GetPickUpPointParam param) {
        return pickUpPointService.getPickUpPoints(param);
    }
    @PostMapping("/setPickUpPointStatus")
    public Response<Boolean> setPickUpPointStatus(@RequestBody SetPointParam param){
        return pickUpPointService.setPickUpPointStatus(param);
    }
    @PostMapping("/updatePickUpPointInfo")
    public Response<Boolean> updatePickUpPointInfo(@RequestBody PickUpPointParam param){
        return pickUpPointService.updatePickPointInfo(param);
    }

    @DeleteMapping("/deletePickUpPoint")
    public Response<Boolean> deletePickUpPoint(@RequestBody DeletePointParam param){
        return pickUpPointService.deletePickUpPoint(param);
    }
    @PostMapping("/getPickUpPointByStoreId")
    public Response<PickUpPointInfoDTO> getPickUpPointByStoreId(@RequestBody GetPointByStoreIdParam param){
        return pickUpPointService.getPickUpPointByStoreId(param);
    }
}
