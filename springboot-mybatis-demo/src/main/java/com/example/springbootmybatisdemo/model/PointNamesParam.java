package com.example.springbootmybatisdemo.model;

import org.apache.catalina.session.StoreBase;

public class PointNamesParam {
    private String storeName;
    private String pickUpPointName;
    private Byte status;

    public String getPickUpPointName() {
        return pickUpPointName;
    }

    public Byte getStatus() {
        return status;
    }

    public String getStoreName() {
        return storeName;
    }
}

