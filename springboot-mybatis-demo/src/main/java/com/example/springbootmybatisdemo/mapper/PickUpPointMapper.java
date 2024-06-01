package com.example.springbootmybatisdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.example.springbootmybatisdemo.dto.*;

@Mapper
public interface PickUpPointMapper {
    @Insert({
            "INSERT INTO pick_up_point",
            "(name, phone_number, province, province_id, city, city_id, district, district_id, detailed_address,",
            "open_time, close_time, store_id, store_name, latitude, longitude, status, transit_time, service_day,",
            "service_start_time, service_end_time, service_duration, service_interval, service_times, is_delete,",
            "create_user, create_time, update_user, update_time)",
            "VALUES",
            "(#{pickUpPointInfoParam.name}, #{pickUpPointInfoParam.phoneNumber}, #{pickUpPointInfoParam.province},",
            "#{pickUpPointInfoParam.provinceId}, #{pickUpPointInfoParam.city}, #{pickUpPointInfoParam.cityId},",
            "#{pickUpPointInfoParam.district}, #{pickUpPointInfoParam.districtId}, #{pickUpPointInfoParam.detailedAddress},",
            "#{pickUpPointInfoParam.openTime}, #{pickUpPointInfoParam.closeTime}, #{pickUpPointInfoParam.storeId},",
            "#{pickUpPointInfoParam.storeName}, #{pickUpPointInfoParam.coordinate.latitude},",
            "#{pickUpPointInfoParam.coordinate.longitude}, #{pickUpPointInfoParam.status}, #{pickUpPointInfoParam.transitTime},",
            "#{pickUpPointInfoParam.serviceDay}, #{pickUpPointInfoParam.serviceStartTime}, #{pickUpPointInfoParam.serviceEndTime},",
            "#{pickUpPointInfoParam.serviceDuration}, #{pickUpPointInfoParam.serviceInterval}, #{pickUpPointInfoParam.serviceTimes},",
            "0, #{userName}, NOW(), #{userName}, NOW())"
    })
    int  insertPickUpPoint(PickUpPointParam pickUpPointParam);
}


