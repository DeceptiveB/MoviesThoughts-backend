package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_id_sequence",
            sequenceName = "post_id_sequence"
    )
    @GeneratedValue(
            generator = "post_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser appUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {
    }

    public Post(String content, AppUser appUser) {
        this.content = content;
        this.appUser = appUser;
    }

    public Post(Integer id, String content, AppUser appUser, List<Comment> comments) {
        this.id = id;
        this.content = content;
        this.appUser = appUser;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
