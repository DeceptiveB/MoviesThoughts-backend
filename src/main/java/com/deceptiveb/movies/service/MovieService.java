package com.deceptiveb.movies.service;

import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.payload.movie.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<ListMovieResponse> getMovies(int page, int size);

    MovieResponse getMovieById(Integer id);
}
