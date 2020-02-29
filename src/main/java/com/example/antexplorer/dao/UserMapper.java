package com.example.antexplorer.dao;

import com.example.antexplorer.pojo.po.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
@Component
public interface UserMapper {
    @Select("select * from user where U_Id=#{userId}")
    User selectUserByPrimaryKey(int userId);
    @Update("UPDATE user SET user.U_Password=#{password} WHERE user.U_Id=#{userId}")
    int UpdateUserPassword(String password, int userId);
    @Insert("Insert into user VALUES(#{U_Id}, #{U_Password}, #{U_Name},#{U_Phone}, #{U_CarPlate}, #{U_IdNum},#{U_Type},#{U_Img})")
    void InsertUser(User user);

}

