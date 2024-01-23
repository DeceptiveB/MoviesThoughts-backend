package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Table
@Entity
public class Genre {
    @Id
    @SequenceGenerator(
            name = "genre_id_sequence",
            sequenceName = "genre_id_sequence"
    )
    @GeneratedValue(
            generator = "genre_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    @NotBlank
    private String name;

    @ManyToMany
    private List<Movie> movies;

    public Genre() {
    }

    public Genre(Integer id, String name, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    public Genre(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }

    public Genre(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}
