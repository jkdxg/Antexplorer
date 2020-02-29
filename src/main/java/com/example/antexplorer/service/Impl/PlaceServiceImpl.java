package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.PlaceMapper;
import com.example.antexplorer.pojo.po.Place;
import com.example.antexplorer.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceMapper placeMapper;
    public List<Place> GetAllPlaces()
    {
        List<Place> ret=new ArrayList<>();
        ret=placeMapper.GetAllPlaces();
        return ret;
    }
    public Place SelectByPrimaryKey(int PId)
    {
        Place ret=new Place();
        ret=placeMapper.GetPlace(PId);
        return ret;
    }

}
