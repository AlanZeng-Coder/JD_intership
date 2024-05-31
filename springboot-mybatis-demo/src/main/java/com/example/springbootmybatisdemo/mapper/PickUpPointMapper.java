package com.example.springbootmybatisdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.springbootmybatisdemo.dto.CreatePickUpPointParam;

@Mapper
public interface PickUpPointMapper {

    @Insert("INSERT INTO pick_up_point (name, phone_number, province, province_id, city, city_id, district, " +
            "district_id, detailed_address, open_time, close_time, store_id, store_name, latitude, longitude, status, " +
            "transit_time, service_day, service_start_time, service_end_time, service_duration, service_interval, " +
            "service_times, is_delete, create_user, create_time, update_user, update_time) " +
            "VALUES (#{param.name}, #{param.phoneNumber}, #{param.province}, #{param.provinceId}, #{param.city}, " +
            "#{param.cityId}, #{param.district}, #{param.districtId}, #{param.detailedAddress}, #{param.openTime}, " +
            "#{param.closeTime}, #{param.storeId}, #{param.storeName}, #{param.latitude}, #{param.longitude}, " +
            "#{param.status}, #{param.transitTime}, #{param.serviceDay}, #{param.serviceStartTime}, #{param.serviceEndTime}, " +
            "#{param.serviceDuration}, #{param.serviceInterval}, #{param.serviceTimes}, #{param.isDelete}, " +
            "#{param.createUser}, #{param.createTime}, #{param.updateUser}, #{param.updateTime})")
    int insertPickUpPoint(@Param("param") CreatePickUpPointParam param);
}


