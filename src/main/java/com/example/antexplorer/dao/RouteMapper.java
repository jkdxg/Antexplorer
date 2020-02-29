package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.pojo.po.Route;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface RouteMapper {
    @Select("Select * from route")
    List<Route> GetAllRoute();
    @Select("Select * from route where R_Id=#{RId}")
    Route SelectRouteByPrimaryKey(int RId);
    @Select("Select * from place where P_District=#{P_District}")
    List<Place> SelectPlaceByDistrict(String P_District);
}
