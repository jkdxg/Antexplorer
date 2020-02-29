package com.example.antexplorer.Util;

import com.spatial4j.core.io.GeohashUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuliang on 2015/3/20.
 */
public class LocationUtils {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    private static double ACLatitude = 0.022;//纬度经度m
    private static double ACLongtitude = 0.022;//经度精度

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    public static List<String> getsurroundshash(double latitude, double longtitude) {

        List<String> ret = new ArrayList<>();
        Map<String, Double> map = new HashMap<>();
        List<Map<String, Double>> list = new ArrayList<>();
        map.put("Lat", latitude + ACLatitude);
        map.put("Log", longtitude - ACLongtitude);
        list.add(map);
        // --------------------------左上------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude + ACLatitude);
        map.put("Log", longtitude);
        list.add(map);
        //---------------------------正上--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude + ACLatitude);
        map.put("Log", longtitude + ACLongtitude);
        list.add(map);
        //---------------------------右上--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude);
        map.put("Log", longtitude - ACLongtitude);
        list.add(map);
        //---------------------------正左--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude);
        map.put("Log", longtitude + ACLongtitude);
        list.add(map);
        //---------------------------正右--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude - ACLatitude);
        map.put("Log", longtitude - ACLongtitude);
        list.add(map);
        //---------------------------左下--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude - ACLatitude);
        map.put("Log", longtitude);
        list.add(map);
        //---------------------------正下--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude - ACLatitude);
        map.put("Log", longtitude + ACLongtitude);
        list.add(map);
        //---------------------------右下--------------------------//
        map = new HashMap<>();
        map.put("Lat", latitude);
        map.put("Log", longtitude);
        list.add(map);
        //-----------------------------本身--------------------------//
        for (int i = 0; i < 9; i++) {
            boolean found = false;
            String temp = GeohashUtils.encodeLatLon(list.get(i).get("Lat"), list.get(i).get("Log"), 5);

            for (int j = 0; j < ret.size(); j++) {
                if (temp.equals(ret.get(j))) found = true;
            }
            if (found==false)
            {
                ret.add(temp);
            }


        }
        return ret;
    }
}