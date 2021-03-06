package com.achords.repository.songRepo;

import com.achords.model.entity.song.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByName(String name);
    List<Author> findAuthorByImgPath(String name);
}
