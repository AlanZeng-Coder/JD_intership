package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.param.get.GetPickUpPointParam;
import com.example.springbootmybatisdemo.param.insert.PickUpPointParam;
import com.example.springbootmybatisdemo.param.set.SetPointParam;
import org.apache.ibatis.annotations.*;
import com.example.springbootmybatisdemo.dto.get.*;


import java.util.List;

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

    @Select("<script>" +
            "SELECT * FROM pick_up_point " +
            "WHERE status = #{param.pointNamesParam.status} " +
            "AND store_name = #{param.pointNamesParam.storeName} " +
            "AND name = #{param.pointNamesParam.pickUpPointName}" +
            "</script>")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "storeName", column = "store_name"),
            @Result(property = "storeId", column = "store_id"),
            @Result(property = "pickUpPointName", column = "name"),
            @Result(property = "status", column = "status"),
            @Result(property = "province", column = "province"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "city", column = "city"),
            @Result(property = "cityId", column = "city_id"),
            @Result(property = "district", column = "district"),
            @Result(property = "districtId", column = "district_id"),
            @Result(property = "detailedAddress", column = "detailed_address"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "openTime", column = "open_time"),
            @Result(property = "closeTime", column = "close_time"),
            @Result(property = "coordinate.latitude", column = "latitude"),
            @Result(property = "coordinate.longitude", column = "longitude"),
            @Result(property = "transitTime", column = "transit_time"),
            @Result(property = "serviceDay", column = "service_day"),
            @Result(property = "serviceStartTime", column = "service_start_time"),
            @Result(property = "serviceEndTime", column = "service_end_time"),
            @Result(property = "serviceDuration", column = "service_duration"),
            @Result(property = "serviceInterval", column = "service_interval"),
            @Result(property = "serviceTimes", column = "service_times")
    })
    List<PickUpPointDTO> getPickUpPoints(@Param("param") GetPickUpPointParam param);
    @Update("UPDATE pick_up_point SET status = #{param.status} WHERE id = #{param.pickUpPointId}")
    boolean setPickUpPointStatus(@Param("param") SetPointParam param);
}


