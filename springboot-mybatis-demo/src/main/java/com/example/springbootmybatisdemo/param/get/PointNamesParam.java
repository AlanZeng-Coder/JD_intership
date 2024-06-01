package com.example.springbootmybatisdemo.param.get;

public class PointNamesParam {
    private String storeName;
    private String pickPointName;
    private Byte status;

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }

    public String getPickPointName() {
        return pickPointName;
    }

    public void setPickPointName(String pickPointName) {
        this.pickPointName = pickPointName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
