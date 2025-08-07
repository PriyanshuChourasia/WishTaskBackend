package com.wish.WishTaskManagement.TaskManagement.services;

import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamCreateDTO;
import com.wish.WishTaskManagement.TaskManagement.dtos.TeamDTO.TeamResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TeamService {

    List<TeamResponseDTO> getAllById(UUID id);

    TeamResponseDTO create(TeamCreateDTO teamCreateDTO);
}
