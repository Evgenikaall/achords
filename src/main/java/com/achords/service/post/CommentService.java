package com.achords.service.post;

import com.achords.model.entity.post.Comment;
import com.achords.repository.postRepo.CommentRepo;
import com.achords.utils.exceptions.CommentNotFoundException;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;

    public Comment findById(Integer id) throws CommentNotFoundException {
        return commentRepo.findById(id).orElseThrow(CommentNotFoundException::new);
    }

}
