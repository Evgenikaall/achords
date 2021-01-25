package com.achords.repository.songRepo;

import com.achords.model.entity.song.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenresRepo extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}
