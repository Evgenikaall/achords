package com.achords.utils.converters;

import com.achords.model.dto.user.RoleDTO;
import com.achords.model.dto.user.UserDTO;
import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.user.Role;
import com.achords.model.entity.user.User;
import com.achords.service.user.RoleService;
import com.achords.service.user.UserService;
import com.achords.utils.exceptions.RoleNotFoundException;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserConverter {

    private final RoleService roleService;

    public UserDTO mapUserToDto(User user){
        return UserDTO.builder()
                .nickname(user.getNickname())
                .role(user.getRole().getRole())
                .avatar(user.getAvatar())
                .registration(user.getRegistration())
                .build();
    }

    public User mapToUser(UserDTO userDTO) throws RoleNotFoundException {
        return User.builder()
                .email(userDTO.getEmail())
                .avatar(userDTO.getAvatar())
                .nickname(userDTO.getNickname())
                .active(true)
                .password(new BCryptPasswordEncoder().encode(userDTO.getPassword()))
                .registration(new Timestamp(System.currentTimeMillis()))
                .role(roleService.findById(2))
                .build();

    }

    public RoleDTO mapRoleToDto(Role role){
        return RoleDTO.builder()
                .users(role.getUsers().stream().map(this::mapUserToDto).collect(Collectors.toSet()))
                .name(role.getRole())
                .build();
    }


}
