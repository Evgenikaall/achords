package com.achords.repository;

import com.achords.model.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionTypeRepo extends JpaRepository<SectionType, Integer> {
}
