package com.achords.repository.songRepo;

import com.achords.model.entity.song.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionTypeRepo extends JpaRepository<SectionType, Integer> {
    Optional<SectionType> findByName(String name);
}
