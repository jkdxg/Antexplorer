package com.example.antexplorer.service;

import com.example.antexplorer.pojo.po.Place;

import java.util.List;

public interface PlaceService {
    List<Place> GetAllPlaces();
    Place SelectByPrimaryKey(int PId);
}
