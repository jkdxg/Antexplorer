package com.example.antexplorer.controller;

import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.interceptor.annotation.Authorization;
import com.example.antexplorer.interceptor.annotation.CurrentUser;
import com.example.antexplorer.manager.TokenManager;
import com.example.antexplorer.pojo.TokenModel;
import com.example.antexplorer.pojo.dto.LoginInfoDTO;
import com.example.antexplorer.pojo.po.user.User;
import com.example.antexplorer.pojo.vo.UserInfoVO;
import com.example.antexplorer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static java.sql.Types.NULL;

//用户信息更改、用户密码更改、用户注销登录等
//创建部落、创建team
//证明是controller层并且返回json
@RestController()
@Controller
@RequestMapping(value="/user")
public class UserController {
    //依赖注入
    @Autowired
    TokenManager tokenManager;
    @Autowired(required = false)
    UserService userService;
    @PostMapping(value="/login")
    public UserInfoVO Login(@RequestBody LoginInfoDTO infoDTO)
    {
        UserInfoVO res=new UserInfoVO();
        int Ttype;
        Ttype=infoDTO.getType();
        if (Ttype==LoginInfoDTO.ADMINTYPE)//如果用户类型是admin 就不需要任何操作
        {
            //todo
        }
        else if (Ttype==LoginInfoDTO.USERTYPE)
        {
            User user=new User();
            user.setU_Id(infoDTO.getUserId());
            user.setU_Password(infoDTO.getPassword());
            if (userService.userLogin(user))
            {
                //登录
                //返回值
                res=userService.GetUser(infoDTO.getUserId());
                System.out.print(1);
                //Redis操作
                TokenModel tokenModel =tokenManager.createToken(infoDTO.getUserId().toString());
                tokenModel.setToken(tokenModel.getUserId()+"_"+tokenModel.getToken());
                res.setTokenModel(tokenModel);
            }
            else  throw new BizException("登陆失败，密码错误或用户不存在");
        }
        else
        {
            throw new BizException("类型不明确");
        }
        return res;
    }
    @Authorization
    @PostMapping(value = "/updatepassword")
    public int UpdatePswd(@RequestBody LoginInfoDTO infoDTO, @CurrentUser User user)
    {

        int res=0;//1成功 0失败
        //int temp=userService.GetUserType(request);
//        if (temp!=2) throw new BizException("没有足够权限操作修改用户密码");
        res=userService.updatepassword(infoDTO.getUserId(),infoDTO.getPassword());
        return res;
    }
    @Authorization
    @PostMapping(value = "/createuser")
    public void InsertUser(@RequestBody User user,@CurrentUser User user1)
    {
        //int temp=userService.GetUserType(request);
        int temp=user1.getU_Type();
        if (temp!=2) throw new BizException("没有足够权限操作创建用户");
        if (userService.GetUser(user.getU_Id()).getId()!=null) throw new BizException("ID"+Integer.toString(user.getU_Id())+"已存在");
        if (user.getU_Id()==NULL) throw new BizException("用户帐号不能为空");
        if (user.getU_Password()==null) user.setU_Password(Integer.toString(user.getU_Id()));
        userService.insertUser(user);
    }
    @GetMapping(value="/123")
    public void yfm()
    {
        throw new BizException("shower time!");
    }



}
