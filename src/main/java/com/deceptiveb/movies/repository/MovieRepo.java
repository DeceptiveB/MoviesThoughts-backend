package com.deceptiveb.movies.repository;

import com.deceptiveb.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByName(String name);
}
