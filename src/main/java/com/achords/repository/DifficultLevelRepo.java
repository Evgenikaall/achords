package com.achords.repository;

import com.achords.model.DifficultLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultLevelRepo extends JpaRepository<DifficultLevel, Integer> {
}
