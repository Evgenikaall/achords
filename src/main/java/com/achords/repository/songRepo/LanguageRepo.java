package com.achords.repository.songRepo;

import com.achords.model.entity.song.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {
    Optional<Language> findByName(String name);
}
