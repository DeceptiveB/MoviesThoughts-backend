package com.deceptiveb.movies.payload.movie;

import java.time.LocalDate;

public record MovieResponse(
        String name,
        String argument,
        String director,

        LocalDate releaseDate
) {
}
