package com.example.antexplorer.service;

import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.pojo.vo.RouteInfoVO;

import java.util.List;

public interface RouteService {
    List<RouteInfoVO> GetAllRoute();
    RouteInfoVO GetRoute(int Rid);
    List<Place> GetPlaceByDistrict(String P_District);
    List<String> ConvertPlaceName(String PId);

}
