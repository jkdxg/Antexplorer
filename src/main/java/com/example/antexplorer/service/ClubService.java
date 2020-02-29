package com.example.antexplorer.service;

import com.example.antexplorer.pojo.po.Club;

public interface ClubService {
    Club SelectByPrimaryKey(int CId);
    Club SelectByUserId(int UId);
}
