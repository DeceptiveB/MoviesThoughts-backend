package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table
@Entity
public class Comment {
    @Id
    @SequenceGenerator(
            name = "comment_id_sequence",
            sequenceName = "comment_id_sequence"
    )
    @GeneratedValue(
            generator = "comment_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "appuser_id", nullable = false)
    private AppUser appUser;


    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @NotBlank
    @Size(min = 10, max = 250)
    private String content;

    public Comment() {
    }

    public Comment(AppUser appUser, Post post, String content) {
        this.appUser = appUser;
        this.post = post;
        this.content = content;
    }

    public Comment(Integer id, AppUser appUser, Post post, String content) {
        this.id = id;
        this.appUser = appUser;
        this.post = post;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
