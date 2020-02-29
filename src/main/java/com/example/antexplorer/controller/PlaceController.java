package com.example.antexplorer.controller;

import com.example.antexplorer.Util.LocationUtils;
import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.vo.RestaurantInfoVO;
import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.service.PlaceService;
import com.example.antexplorer.service.RegisterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/place")
public class PlaceController {
    @Autowired(required = false)
    PlaceService placeService;
    @Autowired(required = false)
    RegisterService registerService;
    @GetMapping(value = "/getallplaces")
    List<Place> GetAllPlaces()
    {
        List<Place> ret=placeService.GetAllPlaces();
        return ret;
    }
    @GetMapping(value = "/getplace")
    Place GetPlace(@RequestParam(value = "PlaceId") int PlaceId)
    {
        Place ret=placeService.SelectByPrimaryKey(PlaceId);
        return ret;
    }
    @GetMapping(value = "/getrestaurant")
    public List <RestaurantInfoVO> GetRestauByDistrict(@RequestParam("DistrictName")String DistricName, @RequestParam("Longtitude")double Longtitude, @RequestParam("Latitude") double Latitude)
    {
        //两重确认 行政区划+Hash
        List <RestaurantInfoVO> ret=new ArrayList<>();
        ret=registerService.GetNearByRestaurant(DistricName,Longtitude,Latitude);
        List<String> list=LocationUtils.getsurroundshash(Latitude,Longtitude);
        ret=registerService.GetNearByRestaurantByGeo(list,Longtitude,Latitude);

        return ret;
    }
    @GetMapping(value = "/getnearbyrestaurant")
    public List <RestaurantInfoVO> GetNearByRestau(@RequestParam("Longtitude")double Longtitude, @RequestParam("Latitude") double Latitude)
    {
        //两重确认 行政区划+Hash
        List <RestaurantInfoVO> ret=new ArrayList<>();
        List<String> list=LocationUtils.getsurroundshash(Latitude,Longtitude);
        ret=registerService.GetNearByRestaurantByGeo(list,Longtitude,Latitude);

        return ret;
    }

    @GetMapping(value = "/findlocation")
    //用于直接输入名字添加饭店信息
    public Place GetLocation(@RequestParam("PlaceName") String PlaceName)
    {
        Place res=new Place();
        String url="https://apis.map.qq.com/ws/geocoder/v1?address=";
        url=url+PlaceName+"&key="+"HHQBZ-ESTKK-XNKJP-A6CHG-EIYAQ-MPFWL";
        RestTemplate restTemplate=new RestTemplate();
        UriComponents uriComponents= UriComponentsBuilder.fromUriString(
                url)
                .build()
                .encode();
        URI uri=uriComponents.toUri();
        Object obj=restTemplate.getForObject(uri,String.class);
        JSONObject jsonObject= JSONObject.fromObject(obj);
        JSONObject result=new JSONObject();
        result=jsonObject.getJSONObject("result");
        if (result.getInt("reliability")<7) throw new BizException("找不到这个地点辣QAQ");
        double longtitude=result.getJSONObject("location").getDouble("lng");
        double latitude=result.getJSONObject("location").getDouble("lat");
        res.setLatitude(latitude);
        res.setLongtitude(longtitude);
        //获取行政区划到区/县
        result=result.getJSONObject("address_components");
        String District=result.getString("province")+result.getString("city")+result.getString("district");
        res.setP_District(District);
        return res;
    }
}
