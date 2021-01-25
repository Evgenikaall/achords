package com.achords.model.dto.song;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DifficultLevelDTO {
    private String name;
    private String imgPath;
}
