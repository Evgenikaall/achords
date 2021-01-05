package com.achords.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "section_type")
public class SectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sectionTypeName;

    @OneToMany
    private List<Song> songListOrderBySectionType = new ArrayList<>();
}
