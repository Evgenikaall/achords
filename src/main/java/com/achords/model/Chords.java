package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chords")
@NoArgsConstructor
@AllArgsConstructor
public class Chords {

    @Id
    private String chordName;

    private String chordImgPath;

}
