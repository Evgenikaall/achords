package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "section_type")
@NoArgsConstructor
@AllArgsConstructor
public class SectionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectionTypeId;

    private String sectionTypeName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sectionType")
    private List<Song> songListOrderBySectionType;
}
