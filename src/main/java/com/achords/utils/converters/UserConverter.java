package com.achords.utils.converters;

import com.achords.model.dto.user.RoleDTO;
import com.achords.model.dto.user.UserDTO;
import com.achords.model.entity.user.Role;
import com.achords.model.entity.user.User;
import com.achords.service.user.UserService;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserConverter {

    private final UserService userService;

    public UserDTO mapUserToDto(User user){
        return UserDTO.builder()
                .nickname(user.getNickname())
                .role(user.getRole().getRole())
                .avatar(user.getAvatar())
                .registration(user.getRegistration())
                .build();
    }

    public RoleDTO mapRoleToDto(Role role){
        return RoleDTO.builder()
                .users(role.getUsers().stream().map(this::mapUserToDto).collect(Collectors.toSet()))
                .name(role.getRole())
                .build();
    }

    public User mapUserToEntity(UserDTO userDTO){
        User user = null;
        try{
            user = userService.findByNickname(userDTO.getNickname());
        } catch (UserNotFoundException e) {
            // log
        }
        return user;
    }

}
