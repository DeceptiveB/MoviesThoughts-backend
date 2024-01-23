package com.deceptiveb.movies.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_id_sequence",
            sequenceName = "movie_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_id_sequence"
    )
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 80)
    private String argument;

    @NotBlank
    private String director;

    @Transient
    private Double rate;

    @Column(
            name = "release_date"
    )
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    public Movie() {
    }

    public Movie(Integer id, String name, String argument, String director, Double rate, LocalDate releaseDate, List<Genre> genres) {
        this.id = id;
        this.name = name;
        this.argument = argument;
        this.director = director;
        this.rate = rate;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }

    public Movie(String name, String argument, String director, Double rate, LocalDate releaseDate, List<Genre> genres) {
        this.name = name;
        this.argument = argument;
        this.director = director;
        this.rate = rate;
        this.releaseDate = releaseDate;
        this.genres = genres;
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

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
