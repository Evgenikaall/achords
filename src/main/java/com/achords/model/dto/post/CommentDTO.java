package com.achords.model.dto.post;

import com.achords.model.dto.user.UserDTO;
import com.achords.model.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Integer id;
    private String comment;
    private UserDTO user;
    private Date commentDate;
}
