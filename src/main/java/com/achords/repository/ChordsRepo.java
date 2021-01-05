package com.achords.repository;

import com.achords.model.Chords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChordsRepo extends JpaRepository<Chords, String> {
}
