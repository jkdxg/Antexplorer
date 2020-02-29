package com.example.antexplorer.service;

import com.example.antexplorer.pojo.po.Team;
import com.example.antexplorer.pojo.vo.TeamInfoVO;

import java.util.List;

public interface TeamService {
    List<Team> GetAllTeam();
    int CreateTeam(Team team);
    TeamInfoVO GetTeam(int TeamId);
}
