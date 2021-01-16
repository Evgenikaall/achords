package com.achords.repository;

import com.achords.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenresRepo extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}
