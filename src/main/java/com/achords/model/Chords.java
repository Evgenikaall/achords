package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "chords")
@NoArgsConstructor
@AllArgsConstructor
public class Chords {

    @Id
    @Column(name = "chord_name")
    private String chordName;

    private String chordImgPath;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Song> songChords;

}
