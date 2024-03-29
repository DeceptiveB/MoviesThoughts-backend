package com.deceptiveb.movies.service;

import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.payload.movie.MovieRequest;
import com.deceptiveb.movies.payload.movie.MovieResponse;

import java.util.List;

public interface MovieService {
    List<ListMovieResponse> getMovies(int page, int size);

    MovieResponse getMovieById(Integer id);

    Movie saveMovie(MovieRequest movieReques);

}
