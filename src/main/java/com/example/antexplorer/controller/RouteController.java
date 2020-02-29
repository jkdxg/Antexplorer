package com.example.antexplorer.controller;

import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.dto.PlaceInfoDTO;
import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.pojo.vo.RouteInfoVO;
import com.example.antexplorer.service.RouteService;
import com.example.antexplorer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value="/route")
public class RouteController {
    @Autowired(required = false)
    RouteService routeService;
    @Autowired(required = false)
    HttpServletRequest request;
    @Autowired(required = false)
    UserService userService;
    @GetMapping(value = "/getallroutes")
    public List<RouteInfoVO> GetAllRoutes()
    {
        List<RouteInfoVO> res=routeService.GetAllRoute();
        return res;
    }
    @GetMapping(value = "/getroute")
    public RouteInfoVO GetRoute(@RequestParam("Rid") String Rid)
    {
        RouteInfoVO res=routeService.GetRoute(Integer.valueOf(Rid));
        return res;
    }
    @PostMapping(value = "/createroute")//只能被管理员使用 只有管理员才有权限生成一条路线
    public int CreateRoute()
    {
        return 0;
    }
    @GetMapping(value = "/getplacebydistrict")
    public List<Place> GetPlaceByDistrict(@RequestParam("District") String District)
    {
        List<Place> list=new ArrayList<>();
        list=routeService.GetPlaceByDistrict(District);
        System.out.println(list.size());
        return list;
    }
    @PostMapping(value = "/createnewplace")
    public int CreateNewPlace(@RequestBody PlaceInfoDTO placeInfoDTO)
    {
        int res=0;
        int temp=userService.GetUserType(request);
        if (temp!=2) throw new BizException("没有足够权限创建新地点");

        return res;
    }



}
