package com.wish.WishTaskManagement.TaskManagement.repositories;

import com.wish.WishTaskManagement.TaskManagement.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByCreatedBy(UUID createdBy);

    List<Task> findByCreatedByOrAssignedTo(UUID createdBy, UUID assignedTo);
}
