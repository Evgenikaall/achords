package com.achords.repository.postRepo;

import com.achords.model.entity.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends PagingAndSortingRepository<Post, Integer> {
}
