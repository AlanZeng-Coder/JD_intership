package com.example.springbootmybatisdemo.dto.get;

import com.example.springbootmybatisdemo.dto.Coordinate;

public class PickUpPointDTO {
    private Long id;
    private String storeName;
    private Long storeId;
    private String pickUpPointName;
    private byte status;
    private String province;
    private Integer provinceId;
    private String city;
    private int cityId;
    private String district;
    private int districtId;
    private String detailedAddress;
    private String phoneNumber;
    private String openTime;
    private String closeTime;
    private Coordinate coordinate;
    private int transitTime;
    private String serviceDay;
    private String serviceStartTime;
    private String serviceEndTime;
    private int serviceDuration;
    private int serviceInterval;
    private String serviceTimes;



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setCoordinate(Coordinate coordinate){ this.coordinate = coordinate;}

    public Coordinate getCoordinate(){ return coordinate;}

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(Integer transitTime) {
        this.transitTime = transitTime;
    }

    public String getServiceDay() {
        return serviceDay;
    }

    public void setServiceDay(String serviceDay) {
        this.serviceDay = serviceDay;
    }

    public String getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(String serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public String getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(String serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Integer getServiceDuration() {
        return serviceDuration;
    }

    public void setServiceDuration(Integer serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public Integer getServiceInterval() {
        return serviceInterval;
    }

    public void setServiceInterval(Integer serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public String getServiceTimes() {
        return serviceTimes;
    }

    public void setServiceTimes(String serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public String getPickUpPointName() {
        return pickUpPointName;
    }

    public Long getId() {
        return id;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public void setPickUpPointName(String pickUpPointName) {
        this.pickUpPointName = pickUpPointName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceDuration(int serviceDuration) {
        this.serviceDuration = serviceDuration;
    }

    public void setServiceInterval(int serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public void setTransitTime(int transitTime) {
        this.transitTime = transitTime;
    }
}
