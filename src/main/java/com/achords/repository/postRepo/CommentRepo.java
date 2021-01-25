package com.achords.repository.postRepo;

import com.achords.model.entity.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
