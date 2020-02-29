package com.example.antexplorer.service;


import com.example.antexplorer.pojo.po.user.User;
import com.example.antexplorer.pojo.vo.UserInfoVO;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    boolean userLogin(User user);
    UserInfoVO GetUser(int userId);
    int updatepassword(int userId, String password);
    void insertUser(User user);
    int GetUserType(HttpServletRequest request);
}
