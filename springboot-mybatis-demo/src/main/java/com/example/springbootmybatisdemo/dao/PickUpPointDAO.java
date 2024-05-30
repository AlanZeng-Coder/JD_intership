package com.example.springbootmybatisdemo.dao;


import com.example.springbootmybatisdemo.model.*;
import java.util.List;

public interface PickUpPointDAO {
    PickUpPoint getPickUpPointById(Long id);
    List<PickUpPoint> getPickUpPoints(String storeName, String pickUpPointName, Byte status, PageParam pageParam);
    void insertPickUpPoint(PickUpPoint pickUpPoint);
    void updatePickUpPoint(PickUpPoint pickUpPoint);
    void deletePickUpPoint(Long id);
}
