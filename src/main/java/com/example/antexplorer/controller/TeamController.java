package com.example.antexplorer.controller;

import com.example.antexplorer.exception.BizException;
import com.example.antexplorer.pojo.po.Club;
import com.example.antexplorer.pojo.po.Team;
import com.example.antexplorer.pojo.vo.RouteInfoVO;
import com.example.antexplorer.pojo.vo.TeamInfoVO;
import com.example.antexplorer.pojo.vo.UserInfoVO;
import com.example.antexplorer.service.ClubService;
import com.example.antexplorer.service.RouteService;
import com.example.antexplorer.service.TeamService;
import com.example.antexplorer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value="/team")
public class TeamController {
    @Autowired(required = false)
    TeamService teamService;
    @Autowired(required = false)
    UserService userService;
    @Autowired(required = false)
    RouteService routeService;
    @Autowired(required = false)
    ClubService clubService;
    @GetMapping (value = "/getallteams")
    public List<Team> GetAllTeams()
    {
        List<Team> list=new ArrayList();
        list=teamService.GetAllTeam();
        return list;
    }
    @PostMapping(value = "/createteam")
    public int CreateTeam(@RequestBody Team team)
    {
        /*
        * -----------------------------------这里要加入是否是部落酋长的验证 只有部落酋长才能创建team-------------
        *
        * */
        //-------------------------检查创建者是否是某个部落的群主--------------------------//
        if (team.getTId()==null) throw new BizException("提交数据方式错误");
        Club club=clubService.SelectByUserId(team.getUId());
        if (club==null) throw new BizException("不是部落群主，没有权限创建队伍");

        UserInfoVO user=userService.GetUser(team.getUId());
        TeamInfoVO teamInfoVO=teamService.GetTeam(team.getTId());
        RouteInfoVO routeInfoVO=routeService.GetRoute(team.getRId());
        if (user.getId()== null) throw new BizException("没有相应的用户！");
        if (teamInfoVO.getTId()!= 0) throw new BizException("TeamId已存在！");
        if (routeInfoVO.getRId()==0) throw new BizException("没有相应的路线！");
        return teamService.CreateTeam(team);
    }
    @GetMapping(value = "/getteam")
    public TeamInfoVO GetTeam(@RequestParam("TId") String TId)
    {
        TeamInfoVO teamInfoVO=teamService.GetTeam(Integer.valueOf(TId));
        return teamInfoVO;
    }

}
