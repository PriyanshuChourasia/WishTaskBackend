package com.wish.WishTaskManagement.TaskManagement.repositories;

import com.wish.WishTaskManagement.TaskManagement.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, UUID> {

    boolean existsByName(String name);
    boolean existsById(UUID id);
}
