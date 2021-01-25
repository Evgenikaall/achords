package com.achords.model.dto.user;

import com.achords.model.dto.post.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String nickname;
    private String role;
    private Date registration;
    private String avatar;
    private Set<CommentDTO> comments = new HashSet<>();
}
