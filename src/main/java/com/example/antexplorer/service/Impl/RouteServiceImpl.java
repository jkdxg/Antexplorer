package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.PlaceMapper;
import com.example.antexplorer.dao.RouteMapper;
import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.pojo.po.Route;
import com.example.antexplorer.pojo.vo.RouteInfoVO;
import com.example.antexplorer.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteMapper routeMapper;
    @Autowired
    PlaceMapper placeMapper;
    public List<RouteInfoVO> GetAllRoute()
    {
        List<Route> list=new ArrayList<>();
        list=routeMapper.GetAllRoute();
        List<RouteInfoVO> ret=new ArrayList<>();
        for (int i=0;i<list.size();i++)
        {
            ret.add(GetRoute(list.get(i).getRId()));
        }

        return ret;
    }
    public RouteInfoVO GetRoute(int Rid)
    {
        Route temp=routeMapper.SelectRouteByPrimaryKey(Rid);
        RouteInfoVO routeInfoVO=new RouteInfoVO();
        if (temp!=null)
        {
            routeInfoVO.setRId(temp.getRId());
            routeInfoVO.setRName(temp.getRName());
            routeInfoVO.setRPlace(ConvertPlaceName(temp.getRPlace()));
        }

        return routeInfoVO;

    }
    public List<Place> GetPlaceByDistrict(String P_District)
    {
        List<Place> res=new ArrayList<>();
        res=routeMapper.SelectPlaceByDistrict(P_District);
        return res;
    }
    public List<String> ConvertPlaceName(String PId)
    {
        //用来通过字符串分割的方法来将主键转换成地名，存成List返回
        List<String> list=new ArrayList<>();
        StringTokenizer str=new StringTokenizer(PId,"&");
        while(str.hasMoreTokens())
        {
            String PlaceName=placeMapper.GetPlace(Integer.valueOf(str.nextToken())).getP_Name();
            list.add(PlaceName);
        }
        return list;
    }
}
