package com.achords.model.dto.post;

import com.achords.model.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private String comment;
    private UserDTO user;
    private Set<PostDTO> posts;
}
