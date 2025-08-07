package com.wish.WishTaskManagement.TaskManagement.services.impl;

import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamResponseDTO;
import com.wish.WishTaskManagement.TaskManagement.entities.Team;
import com.wish.WishTaskManagement.TaskManagement.entities.User;
import com.wish.WishTaskManagement.TaskManagement.exceptions.DataNotExistsValidation;
import com.wish.WishTaskManagement.TaskManagement.mapper.TeamMapper;
import com.wish.WishTaskManagement.TaskManagement.repositories.TeamRepository;
import com.wish.WishTaskManagement.TaskManagement.repositories.UserRepository;
import com.wish.WishTaskManagement.TaskManagement.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<TeamResponseDTO> getAllById(UUID id){
        if(userRepository.existsById(id)){
            throw new DataNotExistsValidation("User doesn't exists");
        }
        List<Team> teams = teamRepository.findByUserId_Id(id);
        List<TeamResponseDTO> teamResponseDTOS = teams.stream().map(team -> TeamMapper.toDTO(team)).toList();
        return teamResponseDTOS;
    }


    @Override
    public TeamResponseDTO create(TeamCreateDTO teamCreateDTO){
        User user = userRepository.findById(UUID.fromString(teamCreateDTO.getUserId())).orElseThrow(()-> new DataNotExistsValidation("User doesn't exists"));
        Team team = new Team();
        team.setName(teamCreateDTO.getName());
        team.setAlias(teamCreateDTO.getAlias());
        team.setDescription(teamCreateDTO.getDescription());
        team.setUserId(user);
        Team createUser = teamRepository.save(team);
        return TeamMapper.toDTO(createUser);
    }
}
