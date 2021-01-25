package com.achords.repository.songRepo;

import com.achords.model.entity.song.Chords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChordsRepo extends JpaRepository<Chords, Integer> {
    Optional<Chords> findByName(String name);
}
