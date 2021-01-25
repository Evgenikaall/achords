package com.achords.repository.userRepo;

import com.achords.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByNickname(String nickname);
    Optional<User> findByEmail(String email);
}
