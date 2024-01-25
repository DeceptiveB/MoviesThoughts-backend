package com.deceptiveb.movies.payload.movie;

import java.time.LocalDate;

public record ListMovieResponse(
        String name,
        String director,
        LocalDate releaseDate
) {
}
