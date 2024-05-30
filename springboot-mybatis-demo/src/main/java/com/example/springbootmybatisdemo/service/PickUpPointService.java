package com.example.springbootmybatisdemo.service;

import com.example.springbootmybatisdemo.dao.PickUpPointDAO;
import com.example.springbootmybatisdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickUpPointService {

    @Autowired
    private PickUpPointDAO pickUpPointDAO;

    public PickUpPoint getPickUpPointById(Long id) {
        return pickUpPointDAO.getPickUpPointById(id);
    }

    public void createPickUpPoint(PickUpPoint pickUpPoint) {
        pickUpPointDAO.insertPickUpPoint(pickUpPoint);
    }

    public void updatePickUpPoint(Long id, PickUpPoint pickUpPoint) {
        pickUpPointDAO.updatePickUpPoint(pickUpPoint);
    }

    public void deletePickUpPoint(Long id) {
        pickUpPointDAO.deletePickUpPoint(id);
    }

    public List<PickUpPoint> getPickUpPoints(String storeName, String pickUpPointName, Byte status, PageParam pageParam) {
        return pickUpPointDAO.getPickUpPoints(storeName, pickUpPointName, status, pageParam);
    }
}
