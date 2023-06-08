package com.blog.apis.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "tbl_post")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column(name = "post_tittle", length = 100, nullable = false)
    private String tittle;
    @Column(length = 1000)
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String imgName;
    private Date addDate;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
