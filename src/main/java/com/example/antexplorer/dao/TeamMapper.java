package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.Team;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface TeamMapper {
    @Select("Select T_Id,U_Id,R_Id from team")
    public List<Team> GetAllTeams();
    @Insert("Insert into team VALUES(#{T_Id}, #{U_Id}, #{R_Id},#{T_Name})")
    public int InsertTeam(Team team);
    @Select("Select * from team where T_Id=#{TeamId}")
    Team SelectTeamByPrimaryKey(int TeamId);
}
