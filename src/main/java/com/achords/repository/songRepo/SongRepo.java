package com.achords.repository.songRepo;

import com.achords.model.entity.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
}
