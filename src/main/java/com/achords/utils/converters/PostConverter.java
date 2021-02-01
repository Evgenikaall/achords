package com.achords.utils.converters;

import com.achords.model.dto.post.PostDTO;
import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.post.Post;
import com.achords.model.entity.song.Song;
import com.achords.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostConverter {

    private final SongConverter songConverter;
    private final UserConverter userConverter;
    private final CommentConverter commentConverter;
    private final UserService userService;

    public PostDTO mapToDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .song(songConverter.mapToDTO(post.getSong()))
                .user(userConverter.mapUserToDto(post.getUser()))
                .views(post.getViews())
                .postDate(post.getPostDate())
                .comments(post.getComments().stream().map(commentConverter::mapToDto).collect(Collectors.toSet()))
                .build();
    }

    public Post mapToEntity(Song song, UserDetailsImpl user) {
        return Post.builder()
                .song(song)
                .postDate(new Timestamp(System.currentTimeMillis()))
                .user(userService.findByUsername(user.getNickname()))
                .views(0)
                .build();
    }


}
