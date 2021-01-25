package com.achords.service.user;

import com.achords.model.entity.user.User;
import com.achords.repository.userRepo.UserRepo;
import com.achords.utils.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User findByNickname(String nickname) throws UserNotFoundException {
        return userRepo.findByNickname(nickname).orElseThrow(UserNotFoundException::new);
    }

}
