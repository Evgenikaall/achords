package com.achords.model.dto;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DifficultLevelDTO {
    private String name;
    private String imgPath;
}
