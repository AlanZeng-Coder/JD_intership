package com.example.springbootmybatisdemo.controller;

import com.example.springbootmybatisdemo.model.PickUpPoint;
import com.example.springbootmybatisdemo.model.GetPickUpPointParam;
import com.example.springbootmybatisdemo.service.PickUpPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pick-up-points")
public class PickUpPointController {

    @Autowired
    private PickUpPointService pickUpPointService;

    @GetMapping("/{id}")
    public ResponseEntity<PickUpPoint> getPickUpPointById(@PathVariable Long id) {
        PickUpPoint pickUpPoint = pickUpPointService.getPickUpPointById(id);
        return ResponseEntity.ok(pickUpPoint);
    }

    @PostMapping("/search")
    public ResponseEntity<List<PickUpPoint>> getPickUpPoints(@RequestBody GetPickUpPointParam getPickUpPointParam) {
        List<PickUpPoint> pickUpPoints = pickUpPointService.getPickUpPoints(
                getPickUpPointParam.getPointNamesParam().getStoreName(),
                getPickUpPointParam.getPointNamesParam().getPickUpPointName(),
                getPickUpPointParam.getPointNamesParam().getStatus(),
                getPickUpPointParam.getPageParam()
        );
        return ResponseEntity.ok(pickUpPoints);
    }

    @PostMapping
    public ResponseEntity<Void> createPickUpPoint(@RequestBody PickUpPoint pickUpPoint) {
        pickUpPointService.createPickUpPoint(pickUpPoint);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePickUpPoint(@PathVariable Long id, @RequestBody PickUpPoint pickUpPoint) {
        pickUpPointService.updatePickUpPoint(id, pickUpPoint);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePickUpPoint(@PathVariable Long id) {
        pickUpPointService.deletePickUpPoint(id);
        return ResponseEntity.ok().build();
    }
}
