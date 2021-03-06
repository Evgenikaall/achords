package com.achords.repository.songRepo;

import com.achords.model.entity.song.Tuning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TuningRepo extends JpaRepository<Tuning, Integer> {
    Optional<Tuning> findByName(String name);
}
