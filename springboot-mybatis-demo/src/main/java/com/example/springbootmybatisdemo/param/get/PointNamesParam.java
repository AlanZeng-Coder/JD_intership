package com.example.springbootmybatisdemo.param.get;

public class PointNamesParam {
    private String storeName;
    private String pickUpPointName;
    private Byte status;

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

    public String getPickUpPointName() {
        return pickUpPointName;
    }

    public void setPickUpPointName(String pickUpPointName) {
        this.pickUpPointName = pickUpPointName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
