package com.achords.repository;

import com.achords.model.entity.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionTypeRepo extends JpaRepository<SectionType, Integer> {
    Optional<SectionType> findByName(String name);
}
