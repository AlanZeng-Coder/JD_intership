package com.example.springbootmybatisdemo.dao.impl;

import com.example.springbootmybatisdemo.dao.PickUpPointDAO;
import com.example.springbootmybatisdemo.mapper.PickUpPointMapper;
import com.example.springbootmybatisdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PickUpPointDAOImpl implements PickUpPointDAO {

    @Autowired
    private PickUpPointMapper pickUpPointMapper;

    @Override
    public PickUpPoint getPickUpPointById(Long id) {
        return pickUpPointMapper.getPickUpPointById(id);
    }

    @Override
    public List<PickUpPoint> getPickUpPoints(String storeName, String pickUpPointName, Byte status, PageParam pageParam) {
        return pickUpPointMapper.getPickUpPoints(storeName, pickUpPointName, status, pageParam);
    }

    @Override
    public void insertPickUpPoint(PickUpPoint pickUpPoint) {
        pickUpPointMapper.insertPickUpPoint(pickUpPoint);
    }

    @Override
    public void updatePickUpPoint(PickUpPoint pickUpPoint) {
        pickUpPointMapper.updatePickUpPoint(pickUpPoint);
    }

    @Override
    public void deletePickUpPoint(Long id) {
        pickUpPointMapper.deletePickUpPoint(id);
    }
}
