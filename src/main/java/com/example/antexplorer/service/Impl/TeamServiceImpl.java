package com.example.antexplorer.service.Impl;

import com.example.antexplorer.dao.TeamMapper;
import com.example.antexplorer.dao.UserMapper;
import com.example.antexplorer.pojo.po.Team;
import com.example.antexplorer.pojo.vo.TeamInfoVO;
import com.example.antexplorer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    UserMapper userMapper;
    public List<Team> GetAllTeam()
    {
        List<Team> list=teamMapper.GetAllTeams();
        return list;
    }
    public int CreateTeam(Team team)
    {

        return teamMapper.InsertTeam(team);
    }
    public TeamInfoVO GetTeam(int TeamId)
    {
        TeamInfoVO ResTeam=new TeamInfoVO();
        Team team=teamMapper.SelectTeamByPrimaryKey(TeamId);
        if (team!=null)
        {
            ResTeam.setRId(team.getRId());
            ResTeam.setT_Name(team.getT_Name());
            ResTeam.setTId(team.getTId());
            ResTeam.setUId(team.getUId());
        }

        return ResTeam;
    }
}
