package com.deceptiveb.movies.controller;

import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.payload.movie.MovieRequest;
import com.deceptiveb.movies.payload.movie.MovieResponse;
import com.deceptiveb.movies.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<ListMovieResponse>> getMovies(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "5", required = false) int size) {
        return ResponseEntity.ok().body(movieService.getMovies(page, size));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieResponse> getMovieById(
            @PathVariable(value="id") Integer id
                                                     ){
        return ResponseEntity.ok().body(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<MovieResponse> saveMovie(
            @Valid @RequestBody MovieRequest movieRequest
            ){
        Movie movie = movieService.saveMovie(movieRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(movie.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
