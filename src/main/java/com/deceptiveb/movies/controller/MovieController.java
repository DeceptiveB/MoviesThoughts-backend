package com.deceptiveb.movies.controller;

import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<ListMovieResponse>> getMovies(
            @RequestParam(
                    value = "page",
                    defaultValue = "0",
                    required = false
            ) int page,
            @RequestParam(
                    value = "size",
                    defaultValue = "5",
                    required = false
            ) int size
    ){
        return ResponseEntity.ok().body(movieService.getMovies(page, size));
    }
}
