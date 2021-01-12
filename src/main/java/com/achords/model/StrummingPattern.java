package com.achords.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@Table(name = "strumming_pattern")
@NoArgsConstructor
@AllArgsConstructor
public class StrummingPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "strumming_pattern_id")
    private Integer strummingPatternId;

    @Column(name = "strumming_pattern_name")
    private String strummingPatternName;

    @Column(name = "strumming_pattern_img_path")
    private String strummingPatternImgPath;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "strummingPatternSet", fetch = EAGER)
    private List<Song> songStrummingPatterns;
}
