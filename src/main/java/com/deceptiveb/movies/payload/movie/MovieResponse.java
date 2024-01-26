package com.deceptiveb.movies.payload.movie;

import java.time.LocalDate;
import java.util.List;

public record MovieResponse(
        String name,
        String argument,
        String director,

        LocalDate releaseDate,

        List<String> genres
) {
}
