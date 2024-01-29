package com.deceptiveb.movies.mapper.movie;

import com.deceptiveb.movies.model.Genre;
import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.payload.movie.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MovieResponseMapper implements Function<Movie, MovieResponse> {
    @Override
    public MovieResponse apply(Movie movie) {
        return new MovieResponse(
                movie.getName(),
                movie.getArgument(),
                movie.getDirector(),
                movie.getReleaseDate(),
                movie.getGenres()
                        .stream()
                        .map(Genre::getName)
                        .collect(Collectors.toList())
        );
    }
}
