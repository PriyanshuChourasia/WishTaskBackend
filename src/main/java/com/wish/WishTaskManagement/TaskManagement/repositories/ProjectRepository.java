package com.wish.WishTaskManagement.TaskManagement.repositories;


import com.wish.WishTaskManagement.TaskManagement.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

    List<Project> findByWorkspaceId(UUID id);
}
