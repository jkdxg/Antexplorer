package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Register.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component

public interface RegisterMapper {
    @Select(value = "Select * from dinning where D_Id=#{DId}")
    Restaurant GetRestaurantByDId(int DId);
    @Select(value="Select * from dinning where D_District=#{District}")
    List<Restaurant> GetRestaurantByDistrict(String District);
    @Select(value="Select * from dinning where GeoHash=#{GeoHash}")
    List<Restaurant> GetRestaurantByGeo(String GeoHash);
}
