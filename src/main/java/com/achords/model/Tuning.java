package com.achords.model;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tuning_instrument")
@NoArgsConstructor
@AllArgsConstructor
public class Tuning{

    @Id
    @Column(name = "tuning")
    private String tuning;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "songTuning", cascade = CascadeType.ALL)
    private List<Song> songListByTuning = new ArrayList<>();
}
