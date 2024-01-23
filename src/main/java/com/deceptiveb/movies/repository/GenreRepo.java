package com.deceptiveb.movies.repository;

import com.deceptiveb.movies.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepo extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}
