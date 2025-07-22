package com.wish.WishTaskManagement.TaskManagement.repositories;


import com.wish.WishTaskManagement.TaskManagement.entities.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, UUID> {

    boolean existsById(UUID id);

    List<UserActivity> findByUserId(UUID userId);
}
