package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Place;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface PlaceMapper {
    @Select("Select * from place")
    List<Place> GetAllPlaces();
    @Select("Select * from place where P_Id=#{PId}")
    Place GetPlace(int PId);
}
