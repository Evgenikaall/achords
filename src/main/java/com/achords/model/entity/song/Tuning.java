package com.achords.model.entity.song;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tuning_instrument", schema = "model")
@NoArgsConstructor
@AllArgsConstructor
public class Tuning{

    @Id
    @Column(name = "tuning_id")
    private Integer id;

    @Column(name = "tuning_name")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "tuning", cascade = CascadeType.ALL)
    private List<Song> songList = new ArrayList<>();
}
