package com.achords.repository;

import com.achords.model.StrummingPattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrummingPatternRepo extends JpaRepository<StrummingPattern, Integer> {
}
