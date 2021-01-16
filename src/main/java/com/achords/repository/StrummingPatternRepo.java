package com.achords.repository;

import com.achords.model.entity.StrummingPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StrummingPatternRepo extends JpaRepository<StrummingPattern, Integer> {
    Optional<StrummingPattern> findByName(String name);
}
