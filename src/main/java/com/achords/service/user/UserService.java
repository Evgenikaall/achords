package com.achords.service.user;

import com.achords.model.dto.user.UserDTO;
import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.user.User;
import com.achords.repository.userRepo.UserRepo;
import com.achords.utils.converters.UserConverter;
import com.achords.utils.exceptions.RoleNotFoundException;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserConverter userConverter;
    public User save(UserDTO userDTO) throws RoleNotFoundException {
        return userRepo.save(userConverter.mapToUser(userDTO));
    }

    public User findByUsername(String nickname) throws UserNotFoundException {
        return userRepo.findByNickname(nickname).orElseThrow(UserNotFoundException::new);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String nickname){
        return new UserDetailsImpl(findByUsername(nickname));
    }
}
