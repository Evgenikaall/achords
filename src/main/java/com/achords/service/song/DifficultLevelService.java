package com.achords.service.song;

import com.achords.model.dto.song.DifficultLevelDTO;
import com.achords.model.entity.song.DifficultLevel;
import com.achords.repository.songRepo.DifficultLevelRepo;
import com.achords.utils.exceptions.DifficultLevelNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DifficultLevelService {

    private final DifficultLevelRepo difficultLevelRepo;

    public DifficultLevel save(DifficultLevel newDifficultLevel) {
        return difficultLevelRepo.save(newDifficultLevel);
    }

    public Set<DifficultLevelDTO> getAll() {
        return difficultLevelRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public DifficultLevel findById(Integer id) throws DifficultLevelNotFoundException {
        return difficultLevelRepo.findById(id).orElseThrow(DifficultLevelNotFoundException::new);
    }

    public DifficultLevel findByName(String difficultLevelName) throws DifficultLevelNotFoundException {
        return difficultLevelRepo.findByName(difficultLevelName).orElseThrow(DifficultLevelNotFoundException::new);
    }


    public void delete(DifficultLevelDTO difficultLevelDTO) throws DifficultLevelNotFoundException {
        difficultLevelRepo.delete(findByName(difficultLevelDTO.getName()));
    }

    public DifficultLevelDTO mapToDTO(DifficultLevel difficultLevel) {
        return DifficultLevelDTO.builder()
                .name(difficultLevel.getName())
                .imgPath(difficultLevel.getImgPath()).build();
    }

    public DifficultLevel mapToEntity(DifficultLevelDTO difficultLevelDTO) throws DifficultLevelNotFoundException {
        return findByName(difficultLevelDTO.getName());
    }
}
