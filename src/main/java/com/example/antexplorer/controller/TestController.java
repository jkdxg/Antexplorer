package com.example.antexplorer.controller;


import com.example.antexplorer.pojo.po.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class TestController {
    @RequestMapping(value = "/test")
    public String test()
    {
        return "hello";
    }
    @RequestMapping(value="/test1")

    public User test1()
    {

        User user=new User();
        return user;
    }
}
