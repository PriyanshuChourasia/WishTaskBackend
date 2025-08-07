package com.wish.WishTaskManagement.TaskManagement.repositories;

import com.wish.WishTaskManagement.TaskManagement.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
