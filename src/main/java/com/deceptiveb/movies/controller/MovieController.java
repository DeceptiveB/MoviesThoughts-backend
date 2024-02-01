package com.deceptiveb.movies.controller;

import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.payload.movie.MovieResponse;
import com.deceptiveb.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<ListMovieResponse>> getMovies(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return ResponseEntity.ok().body(movieService.getMovies(page, size));
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieResponse> getMovieById(
            @PathVariable(value="id") Integer id
                                                     ){
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }
}
