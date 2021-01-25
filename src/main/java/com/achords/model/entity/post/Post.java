package com.achords.model.entity.post;

import com.achords.model.entity.song.Song;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post",schema = "post")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "song_id")
    private Song song;

}
