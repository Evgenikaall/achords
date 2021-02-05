package com.achords.model.dto.user;

import com.achords.model.dto.post.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "Nickname can't be empty")
    private String nickname;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password can't be empty")
    @Length(min = 8, max = 32, message = "Password size 8-32")
    private String password;
    private String role;
    private Date registration;
    private String avatar;
    private Set<CommentDTO> comments = new HashSet<>();
}
