package com.wish.WishTaskManagement.TaskManagement.repositories;

import com.wish.WishTaskManagement.TaskManagement.entities.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkSpaceRepository extends JpaRepository<Workspace, UUID> {

    boolean existsById(UUID id);
}
