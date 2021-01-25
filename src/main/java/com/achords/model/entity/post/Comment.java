package com.achords.model.entity.post;

import com.achords.model.entity.user.User;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "comments", schema = "post_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Lob
    @Column(name = "comment", length = 65535, columnDefinition = "text")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "comment_date")
    private Date commentDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

}
