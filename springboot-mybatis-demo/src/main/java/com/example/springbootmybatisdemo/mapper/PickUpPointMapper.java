package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.param.delete.DeletePointParam;
import com.example.springbootmybatisdemo.param.get.GetPickUpPointParam;
import com.example.springbootmybatisdemo.param.get.GetPointByStoreIdParam;
import com.example.springbootmybatisdemo.param.insertOrUpdate.PickUpPointParam;
import com.example.springbootmybatisdemo.param.set.SetPointParam;
import org.apache.ibatis.annotations.*;
import com.example.springbootmybatisdemo.dto.get.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
            "(#{param.pickUpPointInfoParam.pickUpPointName}, #{param.pickUpPointInfoParam.phoneNumber}, #{param.pickUpPointInfoParam.province},",
            "#{param.pickUpPointInfoParam.provinceId}, #{param.pickUpPointInfoParam.city}, #{param.pickUpPointInfoParam.cityId},",
            "#{param.pickUpPointInfoParam.district}, #{param.pickUpPointInfoParam.districtId}, #{param.pickUpPointInfoParam.detailedAddress},",
            "#{param.pickUpPointInfoParam.openTime}, #{param.pickUpPointInfoParam.closeTime}, #{param.pickUpPointInfoParam.storeId},",
            "#{param.pickUpPointInfoParam.storeName}, #{param.pickUpPointInfoParam.coordinate.latitude},",
            "#{param.pickUpPointInfoParam.coordinate.longitude}, #{param.pickUpPointInfoParam.status}, #{param.pickUpPointInfoParam.transitTime},",
            "#{param.pickUpPointInfoParam.serviceDay}, #{param.pickUpPointInfoParam.serviceStartTime}, #{param.pickUpPointInfoParam.serviceEndTime},",
            "#{param.pickUpPointInfoParam.serviceDuration}, #{param.pickUpPointInfoParam.serviceInterval}, #{param.pickUpPointInfoParam.serviceTimes},",
            "0, #{param.user}, NOW(), #{param.user}, NOW())"
    })
    boolean  createPickUpPoint(@Param("param") PickUpPointParam param);

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

    @Update("UPDATE pick_up_point " +
            "SET store_name = #{param.pickUpPointInfoParam.storeName}, " +
            "store_id = #{param.pickUpPointInfoParam.storeId}, " +
            "name = #{param.pickUpPointInfoParam.pickUpPointName}, " +
            "status = #{param.pickUpPointInfoParam.status}, " +
            "province = #{param.pickUpPointInfoParam.province}, " +
            "province_id = #{param.pickUpPointInfoParam.provinceId}, " +
            "city = #{param.pickUpPointInfoParam.city}, " +
            "city_id = #{param.pickUpPointInfoParam.cityId}, " +
            "district = #{param.pickUpPointInfoParam.district}, " +
            "district_id = #{param.pickUpPointInfoParam.districtId}, " +
            "detailed_address = #{param.pickUpPointInfoParam.detailedAddress}, " +
            "phone_number = #{param.pickUpPointInfoParam.phoneNumber}, " +
            "open_time = #{param.pickUpPointInfoParam.openTime}, " +
            "close_time = #{param.pickUpPointInfoParam.closeTime}, " +
            "latitude = #{param.pickUpPointInfoParam.coordinate.latitude}, " +
            "longitude = #{param.pickUpPointInfoParam.coordinate.longitude}, " +
            "transit_time = #{param.pickUpPointInfoParam.transitTime}, " +
            "service_day = #{param.pickUpPointInfoParam.serviceDay}, " +
            "service_start_time = #{param.pickUpPointInfoParam.serviceStartTime}, " +
            "service_end_time = #{param.pickUpPointInfoParam.serviceEndTime}, " +
            "service_duration = #{param.pickUpPointInfoParam.serviceDuration}, " +
            "service_interval = #{param.pickUpPointInfoParam.serviceInterval}, " +
            "service_times = #{param.pickUpPointInfoParam.serviceTimes}, " +
            "update_user = #{param.user}, " +
            "update_time = now() " +
            "WHERE id = #{param.pickUpPointInfoParam.pickUpPointId}")
    boolean updatePickUpPointInfo(@Param("param") PickUpPointParam param);
    @Delete("DELETE FROM pick_up_point WHERE id = #{param.pickUpPointId}")
    boolean deletePickUpPoint(@Param("param") DeletePointParam param);

    @Select("SELECT * FROM pick_up_point WHERE store_id = #{param.storeId}")
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
    List<PickUpPointDTO> getPickUpPointByStoreId(@Param("param") GetPointByStoreIdParam param);
}


