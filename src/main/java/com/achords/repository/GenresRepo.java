package com.achords.repository;

import com.achords.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepo extends JpaRepository<Genre, Integer> {
}
