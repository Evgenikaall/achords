package com.achords.service.song;

import com.achords.model.dto.song.ChordsDTO;
import com.achords.model.entity.song.Chords;
import com.achords.repository.songRepo.ChordsRepo;
import com.achords.utils.exceptions.ChordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChordsService {

    private final ChordsRepo chordsRepo;

    public Set<ChordsDTO> getAll() {
        return chordsRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public Chords findById(Integer id) throws ChordNotFoundException {
        return chordsRepo.findById(id).orElseThrow(ChordNotFoundException::new);
    }

    public Chords findByName(String name) throws  ChordNotFoundException{
        return chordsRepo.findByName(name).orElseThrow(ChordNotFoundException::new);
    }

    public Chords save(ChordsDTO chordsDTO){
        Chords chords = Chords.builder().name(chordsDTO.getName()).imgPath("pathToUpdate").build();
        System.out.println("I'm here");
        return chordsRepo.save(chords);
    }

    public ChordsDTO mapToDTO(Chords chords){
        return ChordsDTO.builder()
                .name(chords.getName())
                .imgPath(chords.getImgPath())
                .build();
    }

    public Chords mapToEntity(ChordsDTO chordsDTO) throws ChordNotFoundException {
        return findByName(chordsDTO.getName());
    }


}
