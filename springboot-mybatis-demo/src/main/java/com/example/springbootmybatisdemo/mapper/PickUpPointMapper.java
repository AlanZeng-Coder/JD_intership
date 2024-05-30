package com.example.springbootmybatisdemo.mapper;

import com.example.springbootmybatisdemo.model.PickUpPoint;
import com.example.springbootmybatisdemo.model.PageParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PickUpPointMapper {
    @Select("SELECT * FROM pick_up_point WHERE id = #{id}")
    PickUpPoint getPickUpPointById(Long id);

    @Select({
            "<script>",
            "SELECT * FROM pick_up_point",
            "WHERE 1=1",
            "<if test='storeName != null'>",
            "AND store_name LIKE CONCAT('%', #{storeName}, '%')",
            "</if>",
            "<if test='pickUpPointName != null'>",
            "AND name LIKE CONCAT('%', #{pickUpPointName}, '%')",
            "</if>",
            "<if test='status != null'>",
            "AND status = #{status}",
            "</if>",
            "LIMIT #{pageParam.offset}, #{pageParam.pageSize}",
            "</script>"
    })
    List<PickUpPoint> getPickUpPoints(@Param("storeName") String storeName,
                                      @Param("pickUpPointName") String pickUpPointName,
                                      @Param("status") Byte status,
                                      @Param("pageParam") PageParam pageParam);

    @Insert("INSERT INTO pick_up_point (name, phone_number, province, province_id, city, city_id, district, district_id, detailed_address, open_time, close_time, store_id, store_name, latitude, longitude, status, transit_time, service_day, service_start_time, service_end_time, service_duration, service_interval, service_times, is_delete, create_user, create_time, update_user, update_time) VALUES (#{name}, #{phoneNumber}, #{province}, #{provinceId}, #{city}, #{cityId}, #{district}, #{districtId}, #{detailedAddress}, #{openTime}, #{closeTime}, #{storeId}, #{storeName}, #{latitude}, #{longitude}, #{status}, #{transitTime}, #{serviceDay}, #{serviceStartTime}, #{serviceEndTime}, #{serviceDuration}, #{serviceInterval}, #{serviceTimes}, #{isDelete}, #{createUser}, #{createTime}, #{updateUser}, #{updateTime})")
    void insertPickUpPoint(PickUpPoint pickUpPoint);

    @Update("UPDATE pick_up_point SET name=#{name}, phone_number=#{phoneNumber}, province=#{province}, province_id=#{provinceId}, city=#{city}, city_id=#{cityId}, district=#{district}, district_id=#{districtId}, detailed_address=#{detailedAddress}, open_time=#{openTime}, close_time=#{closeTime}, store_id=#{storeId}, store_name=#{storeName}, latitude=#{latitude}, longitude=#{longitude}, status=#{status}, transit_time=#{transitTime}, service_day=#{serviceDay}, service_start_time=#{serviceStartTime}, service_end_time=#{serviceEndTime}, service_duration=#{serviceDuration}, service_interval=#{serviceInterval}, service_times=#{serviceTimes}, is_delete=#{isDelete}, update_user=#{updateUser}, update_time=#{updateTime} WHERE id = #{id}")
    void updatePickUpPoint(PickUpPoint pickUpPoint);

    @Delete("DELETE FROM pick_up_point WHERE id = #{id}")
    void deletePickUpPoint(Long id);
}

