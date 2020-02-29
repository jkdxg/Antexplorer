package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Club;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface ClubMapper {
    @Select(value = "Select * from club Where C_Id=#{CId}")
    Club SelectClubByPrimaryKey(int CId);
    @Select(value = "Select * from club Where U_Id=#{UId}")
    Club SelectClubByUserId(int CId);

}
