package com.achords.repository.songRepo;


import com.achords.model.entity.song.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends PagingAndSortingRepository<Song, Integer>{
}
