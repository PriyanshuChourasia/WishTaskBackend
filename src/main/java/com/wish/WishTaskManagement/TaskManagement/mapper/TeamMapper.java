package com.wish.WishTaskManagement.TaskManagement.mapper;

import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Team;

public class TeamMapper {


    public static TeamResponseDTO toDTO(Team team){
        TeamResponseDTO teamResponseDTO = new TeamResponseDTO();
        teamResponseDTO.setName(team.getName());
        teamResponseDTO.setAlias(team.getAlias());
        teamResponseDTO.setDescription(team.getDescription());
        teamResponseDTO.setCreatedAt(team.getCreatedAt());
        return teamResponseDTO;
    }

    public static Team toModel(TeamCreateDTO teamCreateDTO){
        Team team = new Team();
        team.setName(team.getName());
        if(!teamCreateDTO.getAlias().isBlank()){
            team.setAlias(teamCreateDTO.getAlias());
        }

        if(!teamCreateDTO.getDescription().isBlank()){
            team.setDescription(teamCreateDTO.getDescription());
        }
        return team;
    }
}
