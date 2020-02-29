package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.ClubMapper;
import com.example.antexplorer.pojo.po.Club;
import com.example.antexplorer.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    ClubMapper clubMapper;
    public Club SelectByPrimaryKey(int CId)
    {
        Club ret=new Club();
        ret=clubMapper.SelectClubByPrimaryKey(CId);
        return ret;
    }
    public Club SelectByUserId(int UId)
    {
        Club ret=new Club();
        ret=clubMapper.SelectClubByUserId(UId);
        return ret;
    }
}
