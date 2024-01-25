package com.deceptiveb.movies.mapper.movie;

import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.payload.movie.ListMovieResponse;

import java.util.function.Function;

public class ListMovieResponseMapper implements Function<Movie, ListMovieResponse> {
    @Override
    public ListMovieResponse apply(Movie movie) {
        return new ListMovieResponse(
                movie.getName(),
                movie.getDirector(),
                movie.getReleaseDate()
        );
    }
}
