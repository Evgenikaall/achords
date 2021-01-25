package com.achords.model.dto.song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SectionTypeDTO {
    private String name;
    private String imgPath;
}
