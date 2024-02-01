package com.deceptiveb.movies.payload.movie;

import java.time.LocalDate;

public record ListMovieResponse(
        Integer id,
        String name,
        String director,
        LocalDate releaseDate
) {
}
