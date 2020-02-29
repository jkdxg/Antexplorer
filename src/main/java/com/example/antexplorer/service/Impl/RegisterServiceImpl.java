package com.example.antexplorer.service.Impl;

import com.example.antexplorer.Util.LocationUtils;
import com.example.antexplorer.dao.RegisterMapper;
import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.vo.RestaurantInfoVO;
import com.example.antexplorer.pojo.po.Register.Restaurant;
import com.example.antexplorer.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;
    public List<RestaurantInfoVO> GetNearByRestaurant(String District, double Longtitude, double Latitude)
    {
        List<Restaurant> res=registerMapper.GetRestaurantByDistrict(District);
        List<RestaurantInfoVO> ret=new ArrayList<>();
        if (res==null) throw new BizException("没有对应行政区划");
        for (int i=0;i<res.size();i++)
        {
            RestaurantInfoVO restaurantInfoVO =new RestaurantInfoVO();
            Restaurant temp=res.get(i);
            restaurantInfoVO.setD_District(temp.getD_District());
            restaurantInfoVO.setD_Name(temp.getD_Name());
            restaurantInfoVO.setD_RestStorage(temp.getD_RestStorage());
            restaurantInfoVO.setDistance(LocationUtils.getDistance(Latitude,Longtitude,temp.getLatitude(),temp.getLongtitude()));
            ret.add(restaurantInfoVO);
        }
        return ret;
    }
    public List<RestaurantInfoVO> GetNearByRestaurantByGeo(List<String> Geo, double Longtitude, double Latitude)
    {
        List<RestaurantInfoVO> ret=new ArrayList<>();
        List<Restaurant> RRes=new ArrayList<>();

        for (int i=0;i<Geo.size();i++)
        {
            List<Restaurant> res=new ArrayList<>();
            res=registerMapper.GetRestaurantByGeo(Geo.get(i));
            for (int j=0;j<res.size();j++)
            {
                boolean found=false;
                //在汇总Rest餐厅表中寻找是否有一致的
                for (int k=0;k<RRes.size();k++)
                {
                    if (res.get(j).getD_Id() == RRes.get(k).getD_Id()) found=true;
                }
                //如果找到了就移除那一项
                if (found==false) RRes.add(res.get(j));
                found=false;
            }
        }

        for (int i=0;i<RRes.size();i++)
        {
            RestaurantInfoVO restaurantInfoVO =new RestaurantInfoVO();
            Restaurant temp=RRes.get(i);
            restaurantInfoVO.setD_District(temp.getD_District());
            restaurantInfoVO.setD_Name(temp.getD_Name());
            restaurantInfoVO.setD_RestStorage(temp.getD_RestStorage());
            restaurantInfoVO.setD_Phone(temp.getD_Phone());
            restaurantInfoVO.setDistance(LocationUtils.getDistance(Latitude,Longtitude,temp.getLatitude(),temp.getLongtitude()));
            ret.add(restaurantInfoVO);
        }
        return ret;
    }
}
