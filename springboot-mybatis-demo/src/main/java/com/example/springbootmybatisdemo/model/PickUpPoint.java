package com.example.springbootmybatisdemo.model;

import java.math.BigDecimal;
import java.util.Date;
public class PickUpPoint {
    private Long id;
    private String name;
    private String phoneNumber;
    private String province;
    private Integer provinceId;
    private String city;
    private Integer cityId;
    private String district;
    private Integer districtId;
    private String detailedAddress;
    private String openTime;
    private String closeTime;
    private Long storeId;
    private String storeName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Byte status;
    private Integer transitTime;
    private String serviceDay;
    private String serviceStartTime;
    private String serviceEndTime;
    private Integer serviceDuration;
    private Integer serviceInterval;
    private String serviceTimes;
    private Boolean isDelete;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
}
