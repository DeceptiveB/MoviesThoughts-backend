package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @DecimalMax("10.0") @DecimalMin("0.0")
    private double rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {
    }

    public Post(String content, AppUser appUser, Movie movie, double rate) {
        this.content = content;
        this.appUser = appUser;
        this.movie = movie;
        this.rate = rate;
    }

    public Post(Integer id, String content, AppUser appUser, Movie movie, double rate) {
        this.id = id;
        this.content = content;
        this.appUser = appUser;
        this.movie = movie;
        this.rate = rate;
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
