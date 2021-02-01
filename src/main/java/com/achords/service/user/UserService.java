package com.achords.service.user;

import com.achords.model.dto.user.UserDetailsImpl;
import com.achords.model.entity.user.User;
import com.achords.repository.userRepo.UserRepo;
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

    public User findByUsername(String nickname) throws UsernameNotFoundException {
        return userRepo.findByNickname(nickname).orElseThrow(()->new UsernameNotFoundException("Not found: " + nickname));
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        return new UserDetailsImpl(findByUsername(nickname));
    }
}
