package com.example.antexplorer.service;

import com.example.antexplorer.pojo.vo.RestaurantInfoVO;

import java.util.List;

public interface RegisterService {
    //根据行政区划来寻找饭店
    public List<RestaurantInfoVO> GetNearByRestaurant(String District, double Longtitude, double Latitude);
    //根据GeoHash来寻找饭店
    List<RestaurantInfoVO> GetNearByRestaurantByGeo(List<String> Geo, double Longtitude, double Latitude);
}
