package com.achords.model.dto.post;

import com.achords.model.dto.song.SongDTO;
import com.achords.model.dto.user.UserDTO;
import com.achords.model.entity.post.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Integer id;
    private SongDTO song;
    private UserDTO user;
    private Integer views;
    private Date postDate;
    private Set<CommentDTO> comments = new HashSet<>();
}
