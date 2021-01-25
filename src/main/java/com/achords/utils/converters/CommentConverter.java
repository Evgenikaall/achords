package com.achords.utils.converters;

import com.achords.model.dto.post.CommentDTO;
import com.achords.model.entity.post.Comment;
import com.achords.repository.postRepo.CommentRepo;
import com.achords.utils.exceptions.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentConverter {

    private final UserConverter userConverter;
    private final CommentRepo commentRepo;

    public CommentDTO mapToDto(Comment comment){
        return CommentDTO.builder()
                .id(comment.getId())
                .comment(comment.getComment())
                .commentDate(comment.getCommentDate())
                .user(userConverter.mapUserToDto(comment.getUser()))
                .build();
    }

    public Comment mapToExistEntity(CommentDTO commentDTO) throws CommentNotFoundException {
        return commentRepo.findById(commentDTO.getId()).orElseThrow(CommentNotFoundException::new);
    }
}
