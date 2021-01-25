package com.achords.model.dto.post;

import com.achords.model.dto.song.SongDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private SongDTO songDTO;
}
