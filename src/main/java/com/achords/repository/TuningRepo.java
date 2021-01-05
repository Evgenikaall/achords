package com.achords.repository;

import com.achords.model.Tuning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuningRepo extends JpaRepository<Tuning, String> {
}
