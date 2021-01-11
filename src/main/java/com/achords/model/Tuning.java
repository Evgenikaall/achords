package com.achords.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "instrument_tuning")
@NoArgsConstructor
@AllArgsConstructor
public class Tuning{

    @Id
    private String tuning;

    @OneToMany
    private List<Song> songList;
}
