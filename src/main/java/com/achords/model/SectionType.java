package com.achords.model;

import lombok.*;

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
    @Column(name = "section_type_id")
    private Integer sectionTypeId;

    @Column(name = "section_type_name")
    private String sectionTypeName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "sectionType", cascade = CascadeType.ALL)
    private List<Song> songListBySectionType = new ArrayList<>();
}
