package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.UserMapper;
import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.po.user.User;
import com.example.antexplorer.pojo.vo.UserInfoVO;
import com.example.antexplorer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public boolean userLogin(User user)
    {
        if (user==null) return false;
        User temp=userMapper.selectUserByPrimaryKey(user.getU_Id());
        //返回值
        return(temp!=null && temp.getU_Password().equals(user.getU_Password()));
    }

    public UserInfoVO GetUser(int userId) {
        UserInfoVO userInfoVO=new UserInfoVO();
        User temp=userMapper.selectUserByPrimaryKey(userId);
        if (temp!=null)
        {
            userInfoVO.setUsername(temp.getU_Name());
            userInfoVO.setPhone(temp.getU_Phone());
            userInfoVO.setIdnum(temp.getU_IdNum());
            userInfoVO.setCarplate(temp.getU_CarPlate());
            userInfoVO.setPassword(temp.getU_Password());
            userInfoVO.setId(userId);
            userInfoVO.setU_Type(temp.getU_Type());
        }
        return userInfoVO;
    }

    public int updatepassword(int userId, String password) {
        return userMapper.UpdateUserPassword(password,userId);
    }
    public void insertUser(User user)
    {
        userMapper.InsertUser(user);
    }
    public int GetUserType(HttpServletRequest request)
    {
        Integer UserId=Integer.parseInt(request.getHeader("CurrentUserId"));
        if (UserId==null) throw new BizException("头部没有添加CurrentUserId字段");
        User res=userMapper.selectUserByPrimaryKey(UserId);
        if (res.getU_Password()==null) throw new BizException("CurrentUserId验证失败，没有相应用户");
        return res.getU_Type();
    }

}
