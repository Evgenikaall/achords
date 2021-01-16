package com.achords.repository;

import com.achords.model.entity.DifficultLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultLevelRepo extends JpaRepository<DifficultLevel, Integer> {
    Optional<DifficultLevel> findByName(String name);
}
